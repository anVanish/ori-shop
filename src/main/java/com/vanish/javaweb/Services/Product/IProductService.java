package com.vanish.javaweb.Services.Product;

import com.vanish.javaweb.Entities.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product findById(int id);
    void insert(Product product);
    void update(Product product);
    void delete(int id);
}
