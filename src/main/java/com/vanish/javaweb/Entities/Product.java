package com.vanish.javaweb.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Product")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(length = 255)
    private String productName;

    private int stock;
    private int price;
    private String imageLink;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;

    public Product() {}

    public Product(Builder builder) {
        this.productId = builder.productId;
        this.description = builder.description;
        this.productName = builder.productName;
        this.stock = builder.stock;
        this.price = builder.price;
        this.imageLink = builder.imageLink;
        this.category = builder.category;
    }

    //getter
    public int getProductId() {
        return productId;
    }

    public String getDescription() {
        return description;
    }

    public String getProductName() {
        return productName;
    }

    public int getStock() {
        return stock;
    }

    public int getPrice() {
        return price;
    }

    public String getImageLink() {
        return imageLink;
    }

    public Category getCategory() {
        return category;
    }

    //setter
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    //Builder
    public static class Builder{
        private int productId;
        private String description;
        private String productName;

        private int stock;
        private int price;
        private String imageLink;
        private Category category;

        public Builder setProductId(int productId) {
            this.productId = productId;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        public Builder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Builder setImageLink(String imageLink) {
            this.imageLink = imageLink;
            return this;
        }

        public Builder setCategory(Category category){
            this.category = category;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", description='" + description + '\'' +
                ", productName='" + productName + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", imageLink='" + imageLink + '\'' +
                ", category=" + category +
                '}';
    }
}
