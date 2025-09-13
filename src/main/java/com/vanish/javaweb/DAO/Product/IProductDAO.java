package com.vanish.javaweb.DAO.Product;
import com.vanish.javaweb.Entities.Product;

import java.util.List;

public interface IProductDAO {
    List<Product> findAll();
    Product findById(int id);
    void insert(Product product);
    void update(Product product);
    void delete(int id);
}
