package com.vanish.javaweb.Model;

import com.vanish.javaweb.Entities.User;

import javax.persistence.Column;

public class UserModel {
    private int userId;
    @Column(length = 255)
    private String userName;
    private String email;
    private String city;
    private String district;
    private String ward;
    private String street;
    private boolean isAdmin;

    public UserModel() {
    }

    public UserModel(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.city = user.getCity();
        this.district = user.getDistrict();
        this.ward = user.getWard();
        this.street = user.getStreet();
        this.isAdmin = user.getIsAdmin();
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getWard() {
        return ward;
    }

    public String getStreet() {
        return street;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", ward='" + ward + '\'' +
                ", street='" + street + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
