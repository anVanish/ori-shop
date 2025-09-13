package com.vanish.javaweb.Services.Category;

import com.vanish.javaweb.Entities.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Category findCateById(int id);

    void insert(Category category);

    void update(Category category);

    void delete(int id);
}
