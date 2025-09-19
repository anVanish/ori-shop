package com.vanish.javaweb.DAO.Order;

import com.vanish.javaweb.Entities.Order;

import java.util.List;

public interface IOrderDAO {
    List<Order> findAll();

    List<Order> findAllByUser(int userId);

    Order findById(int orderId);

    void insert(Order order);

    void updateStatus(String status);

    void delete(int orderId);
}
