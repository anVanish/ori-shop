package com.vanish.javaweb.Model;

import com.vanish.javaweb.Entities.User;


public class UserModel {
    private int userId;
    private String userName;
    private String email;
    private String phone;
    private String city;
    private String district;
    private String ward;
    private String street;
    private boolean isAdmin;
    private String imageLink;

    public UserModel() {
    }

    public UserModel(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.city = user.getCity();
        this.district = user.getDistrict();
        this.ward = user.getWard();
        this.street = user.getStreet();
        this.isAdmin = user.getIsAdmin();
        this.imageLink = user.getImageLink();
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

    public String getImageLink() {
        return imageLink;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", ward='" + ward + '\'' +
                ", street='" + street + '\'' +
                ", isAdmin=" + isAdmin +
                ", imageLink='" + imageLink + '\'' +
                '}';
    }
}
