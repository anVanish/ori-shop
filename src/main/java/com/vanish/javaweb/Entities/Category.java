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
    private int categoryId;

    @Column(columnDefinition = "nvarchar(200)")
    private String categoryName;

    @OneToMany(mappedBy="category", fetch=FetchType.EAGER)
    private List<Product> products;

    public Category(int categoryId, String categoryName) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category(Builder builder) {
        this.categoryName = builder.categoryName;
        this.categoryId = builder.categoryId;
    }

    public Category() {
        super();
    }

    //getters
    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public static class Builder{
        private int categoryId;
        private String categoryName;

        public Builder setCategoryId(int categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder setCategoryName(String categoryName) {
            this.categoryName = categoryName;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }

    @Override
    public String toString() {
        return "Category{" +
                "CategoryName='" + categoryName + '\'' +
                ", CategoryId=" + categoryId +
                '}';
    }
}
