package com.cst19.unimed.Entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserBio {
    @Id
    private String _id;
    private String regNo;
    private String nic;
    private int age;
    private String gender;
    private double height;
    private double weight;
    private String bloodGroup;
    private String allergies;
    private String phoneNo;
    private Boolean bioalert;

    public UserBio(String _id, String regNo, String nic, int age, String gender, double height, double weight, String bloodGroup, String allergies, String phoneNo, Boolean bioalert) {
        this._id = _id;
        this.regNo = regNo;
        this.nic = nic;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
        this.phoneNo = phoneNo;
        this.bioalert = bioalert;
    }

    public UserBio() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Boolean getBioalert() {
        return bioalert;
    }

    public void setBioalert(Boolean bioalert) {
        this.bioalert = bioalert;
    }

    @Override
    public String toString() {
        return "UserBio{" +
                "_id='" + _id + '\'' +
                ", regNo='" + regNo + '\'' +
                ", nic='" + nic + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", allergies='" + allergies + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", bioalert=" + bioalert +
                '}';
    }
}
