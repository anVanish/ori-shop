package com.vanish.javaweb.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "OrderItem")
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    // Many items belong to 1 order
    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order order;

    // Many items refer to 1 product
    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    private double productPrice;

    private int quantity;

    private double total;

    //constructor
    public OrderItem() {
    }

    public OrderItem(Builder builder) {
        this.orderItemId = builder.orderItemId;
        this.order = builder.order;
        this.product = builder.product;
        this.quantity = builder.quantity;
        this.total = builder.total;
        this.productPrice = builder.productPrice;
    }

    //getter
    public int getOrderItemId() {
        return orderItemId;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public double getProductPrice() {
        return productPrice;
    }

    //setter
    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    //builder
    public static class Builder {
        private int orderItemId;
        private Order order;
        private Product product;
        private int quantity;
        private double total;
        private double productPrice;

        public Builder setOrderItemId(int orderItemId) {
            this.orderItemId = orderItemId;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setTotal(double total) {
            this.total = total;
            return this;
        }

        public Builder setProductPrice(double productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        public OrderItem build() {
            return new OrderItem(this);
        }
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
