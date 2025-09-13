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

    public Product(int productId, String description, String productName, int stock, int price, String imageLink) {
        super();
        this.productId = productId;
        this.description = description;
        this.productName = productName;
        this.stock = stock;
        this.price = price;
        this.imageLink = imageLink;
    }

    public Product() {
        super();
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

    //Builder
    public static class Builder{
        private int productId;
        private String description;
        private String productName;

        private int stock;
        private int price;
        private String imageLink;

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
    }

    @Override
    public String toString() {
        return "Product{" +
                "imageLink='" + imageLink + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", ProductName='" + productName + '\'' +
                ", Description='" + description + '\'' +
                ", ProductId=" + productId +
                '}';
    }
}
