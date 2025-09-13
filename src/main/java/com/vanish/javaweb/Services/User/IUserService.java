package com.vanish.javaweb.Services.User;

import com.vanish.javaweb.Entities.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    User findById(int id);

    User findByEmail(String email);

//    boolean insert(User user);

    User signup(String email, String plainPassword, String confirmedPassword) throws Exception;

    User login(String email, String plainPassword) throws Exception;

//    boolean update(User user);

    void deleteById(int id);
}
