package com.vanish.javaweb.Services.Product;

import com.vanish.javaweb.DAO.Product.ProductDAOImpl;
import com.vanish.javaweb.Entities.Product;

import java.util.List;

public class ProductServiceImpl implements IProductService{
    ProductDAOImpl productDAO = new ProductDAOImpl();

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(int id) {
        return productDAO.findById(id);
    }

    @Override
    public void insert(Product product) {
        productDAO.insert(product);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public void delete(int id) {
        productDAO.delete(id);
    }
}
