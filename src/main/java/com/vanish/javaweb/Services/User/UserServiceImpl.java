package com.vanish.javaweb.Services.User;

import com.vanish.javaweb.DAO.User.UserDAOIpml;
import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.Utils.PasswordUtil;

import java.util.List;

public class UserServiceImpl implements IUserService {
    UserDAOIpml userDAO = new UserDAOIpml();

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public User signup(String email, String plainPassword, String confirmedPassword) throws Exception {
        User existUser = userDAO.findByEmail(email);
        if (existUser != null) {
            throw new Exception("User exist");
        }
        if (!plainPassword.equals(confirmedPassword)) {
            throw new Exception("Confirm password not correct");
        }
        String hashedPassword = PasswordUtil.hashPassword(plainPassword);
        User user = new User.Builder()
                .setEmail(email)
                .setPassword(hashedPassword)
                .build();

        //save user
        userDAO.insert(user);

        return user;
    }

    @Override
    public User login(String email, String plainPassword) throws Exception {
        //check user exist
        User user = userDAO.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found");
        }
        //check password
        if (!PasswordUtil.verifyPassword(plainPassword, user.getPassword())) {
            throw new Exception("Password incorrect");
        }
        return user;
    }

    @Override
    public void deleteById(int id) {
        userDAO.deleteById(id);
    }

    @Override
    public void insert(User user) {
        userDAO.insert(user);
    }

    @Override
    public void update(User user) {
        userDAO.update(user);
    }

    @Override
    public void updatePassword(int userId, String oldPassword, String newPassword) throws Exception {
        User user = userDAO.findById(userId);
        if (user == null) throw new Exception("User not found");
        if (!PasswordUtil.verifyPassword(oldPassword, user.getPassword())) throw new Exception("Password incorrect");
        String hashPassword = PasswordUtil.hashPassword(newPassword);
        user.setPassword(hashPassword);
        userDAO.update(user);
    }
}
