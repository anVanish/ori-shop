package com.vanish.javaweb.DAO.Category;

import com.vanish.javaweb.Entities.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> findAll();
    Category findById(int id);
    void insert(Category category);
    void update(Category category);
    void delete(int id);
}
