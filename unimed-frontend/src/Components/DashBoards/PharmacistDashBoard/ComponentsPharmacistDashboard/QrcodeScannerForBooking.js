import React, { useState } from "react";
import { QrReader } from "react-qr-reader";
import axios from "axios";
import "./qrcssforBooking.css";

const QrcodeScannerForBooking = ({ setShowQrDiv }) => {
    const [data, setData] = useState("No result");
    const [scanning, setScanning] = useState(true);
    const [alert, setAlert] = useState(null);

    const handleScan = async (result) => {
        if (result?.text) {
            setData(result.text);
            setScanning(false);

            try {
                const response = await axios.get(`http://localhost:8088/api/v1/user/checkNic/${result.text}`);
                if (response.status === 200) {
                    const userBio = response.data;
                    localStorage.setItem('scannedPID', userBio._id);
                    console.log(userBio._id);

                    // Create booking slot
                    await createBooking(userBio._id);
                }
            } catch (error) {
                if (error.response && error.response.status === 404) {
                    setAlert("User profile not found");
                } else {
                    console.error(error);
                    setAlert("An error occurred while checking the user profile");
                }
            }
        }
    };

    const createBooking = async (patientId) => {
        try {
            const response = await axios.post(`http://localhost:8088/api/v1/booking/create/${patientId}`);
            if (response.status === 200) {
                console.log("Booking created:", response.data);
                setAlert("Time slot Booked");
            }
        } catch (error) {
            console.error("Error creating booking:", error);
            setAlert("An error occurred while creating the booking");
        }
    };

    const handleError = (err) => {
        console.error(err);
    };

    const startScanning = () => {
        setData("No result");
        setScanning(true);
        setAlert(null);
    };

    const stopScanning = () => {
        setScanning(false);
        setShowQrDiv(false);
    };

    return (
        <div className="qrCodeScanner col">
            <div>
                <p className="qrCodeScannerIntroduction">Please place the QR Code inside the camera range.</p>
            </div>
            <div className="qrCodeReader row">
                {scanning ? (
                    <>
                        <QrReader
                            className="ScanerPart"
                            onResult={handleScan}
                            onError={handleError}
                            constraints={{ facingMode: "environment" }}
                        />
                        <button onClick={stopScanning} className="btn btn-danger">
                            Stop Scanning
                        </button>
                    </>
                ) : (
                    <>
                    <button onClick={startScanning} className="btn btn-success">
                        Start Scan again
                    </button>
                    <button onClick={stopScanning} className="btn btn-danger">
                            Cancel Scanning
                    </button>
                    </>                    
                    
                )}
            </div>
            <div className="qrCodeResults row">
                <p>{data}</p>
                {alert && <div className="alert alert-danger" role="alert">{alert}</div>}
            </div>
        </div>
    );
};

export default QrcodeScannerForBooking;
