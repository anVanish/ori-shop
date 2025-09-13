package com.vanish.javaweb.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Category")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int CategoryId;

    @Column(columnDefinition = "nvarchar(200)")
    private String CategoryName;

    @OneToMany(mappedBy="category", fetch=FetchType.EAGER)
    private List<Product> products;

    public Category(int categoryId, String categoryName) {
        super();
        CategoryId = categoryId;
        CategoryName = categoryName;
    }

    public Category() {
        super();
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setCategoryId(int categoryId) {
        CategoryId = categoryId;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryName='" + CategoryName + '\'' +
                ", CategoryId=" + CategoryId +
                '}';
    }
}
