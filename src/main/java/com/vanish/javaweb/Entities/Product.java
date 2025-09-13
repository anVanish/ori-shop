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
    private int ProductId;
    @Column(columnDefinition = "TEXT")
    private String Description;
    @Column(length = 255)
    private String ProductName;

    private int stock;
    private int price;
    private String imageLink;

    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;

    public Product(int productId, String description, String productName, int stock, int price, String imageLink) {
        super();
        ProductId = productId;
        Description = description;
        ProductName = productName;
        this.stock = stock;
        this.price = price;
        this.imageLink = imageLink;
    }

    public Product() {
        super();
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setProductName(String productName) {
        ProductName = productName;
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

    public int getProductId() {
        return ProductId;
    }

    public String getDescription() {
        return Description;
    }

    public String getProductName() {
        return ProductName;
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

    @Override
    public String toString() {
        return "Product{" +
                "imageLink='" + imageLink + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", ProductName='" + ProductName + '\'' +
                ", Description='" + Description + '\'' +
                ", ProductId=" + ProductId +
                '}';
    }
}
