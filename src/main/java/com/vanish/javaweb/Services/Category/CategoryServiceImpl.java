package com.vanish.javaweb.Services.Category;

import com.vanish.javaweb.DAO.Category.CategoryDAOImpl;
import com.vanish.javaweb.Entities.Category;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService{
    CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

    @Override
    public List<Category> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public Category findCateById(int id) {
        return categoryDAO.findById(id);
    }

    @Override
    public void insert(Category category) {
        categoryDAO.insert(category);
    }

    @Override
    public void update(Category category) {
        categoryDAO.update(category);
    }

    @Override
    public void delete(int id) {
        categoryDAO.delete(id);
    }
}
