package com.vanish.javaweb.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
@NamedQuery(name = "Order.findAllByUser", query = "SELECT o FROM Order o WHERE o.user.userId = :userId")
@NamedQuery(name = "Order.updateStatus", query = "UPDATE Order o SET o.orderStatus = :status WHERE o.orderId = :orderId")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    // Many orders belong to 1 user
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    private String orderStatus = "confirm";

    private double orderTotal;

    private LocalDateTime orderDate = LocalDateTime.now();

    //address
    private String phone;

    private String userName;

    private String email;

    private String city;

    private String district;

    private String ward;

    private String street;

    // 1 order has many items
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    public Order() {
    }

    public Order(Builder builder) {
        this.orderId = builder.orderId;
        this.user = builder.user;
        this.orderStatus = builder.orderStatus;
        this.orderTotal = builder.orderTotal;
        this.orderDate = builder.orderDate;
        this.phone = builder.phone;
        this.userName = builder.userName;
        this.email = builder.email;
        this.city = builder.city;
        this.district = builder.district;
        this.ward = builder.ward;
        this.street = builder.street;
        this.orderItems = builder.orderItems;
    }

    //getter
    public int getOrderId() {
        return orderId;
    }

    public User getUser() {
        return user;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Date getOrderDateAsDate(){
        if (orderDate == null) return null;
        return Date.from(orderDate.atZone(java.time.ZoneId.systemDefault()).toInstant());
    }

    public String getPhone() {
        return phone;
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

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    //setter
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public static class Builder {
        private int orderId;
        private User user;
        private String orderStatus = "confirm";
        private double orderTotal;
        private LocalDateTime orderDate = LocalDateTime.now();
        private String phone;
        private String userName;
        private String email;
        private String city;
        private String district;
        private String ward;
        private String street;
        private List<OrderItem> orderItems;

        public Builder setOrderId(int orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder setOrderTotal(double orderTotal) {
            this.orderTotal = orderTotal;
            return this;
        }

        public Builder setOrderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
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

        public Builder setOrderItems(List<OrderItem> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderTotal=" + orderTotal +
                ", orderDate=" + orderDate +
                ", phone='" + phone + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", ward='" + ward + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
