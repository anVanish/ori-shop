package com.vanish.javaweb.Services.Order;

import com.vanish.javaweb.Entities.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAllByUser(int userId);

    Order findById(int orderId);

    void insert(Order order);

    void updateStatus(String status);

    void delete(int orderId);
}
