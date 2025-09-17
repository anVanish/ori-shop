package com.vanish.javaweb.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(length = 255)
    private String userName;
    private String phone;
    private String email;
    private String password;
    private String city;
    private String district;
    private String ward;
    private String street;
    private boolean isAdmin;
    private String imageLink;

    public User() {
    }

    public User(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.email = builder.email;
        this.password = builder.password;
        this.phone = builder.phone;
        this.city = builder.city;
        this.district = builder.district;
        this.ward = builder.ward;
        this.street = builder.street;
        this.imageLink = builder.imageLink;
        this.isAdmin = builder.isAdmin;
    }

    //getters
    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isAdmin() {
        return isAdmin;
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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public String getImageLink() {
        return imageLink;
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

    public void setPassword(String password) {
        this.password = password;
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

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    //Builder
    public static class Builder {
        private int userId;
        @Column(length = 255)
        private String userName;
        private String email;
        private String password;
        private String phone;
        private String city;
        private String district;
        private String ward;
        private String street;
        private boolean isAdmin = false;
        private String imageLink;

        public Builder setUserId(int userId) {
            this.userId = userId;
            return this;

        }

        public Builder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setDistrict(String district) {
            this.district = district;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setAdmin(boolean admin) {
            isAdmin = admin;
            return this;
        }

        public Builder setImageLink(String imageLink) {
            this.imageLink = imageLink;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
