package com.vanish.javaweb.DAO.User;

import com.vanish.javaweb.Entities.User;

import java.util.List;

public interface IUserDAO {
    List<User> findAll();

    User findById(int id);

    User findByEmail(String email);

    void insert(User user);

    void update(User user);

    void deleteById(int id);
}
