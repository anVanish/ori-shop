package com.vanish.javaweb.Services.User;

import com.vanish.javaweb.Entities.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(int id);

    User findByEmail(String email);

    void insert(User user);

    User signup(String email, String plainPassword, String confirmedPassword) throws Exception;

    User login(String email, String plainPassword) throws Exception;

    void update(User user);

    void updatePassword(int userId, String oldPassword, String newPassword) throws Exception;

    void deleteById(int id);
}
