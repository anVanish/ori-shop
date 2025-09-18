package com.vanish.javaweb.Services.Order;

import com.vanish.javaweb.DAO.Order.OrderDAOImpl;
import com.vanish.javaweb.Entities.Order;

import java.util.List;

public class OrderServiceImpl implements IOrderService {
    OrderDAOImpl orderDAO = new OrderDAOImpl();

    @Override
    public List<Order> findAllByUser(int userId) {
        return orderDAO.findAllByUser(userId);
    }

    @Override
    public Order findById(int orderId) {
        return orderDAO.findById(orderId);
    }

    @Override
    public void insert(Order order) {
        orderDAO.insert(order);
    }

    @Override
    public void updateStatus(String status) {
        orderDAO.updateStatus(status);
    }

    @Override
    public void delete(int orderId){
        orderDAO.delete(orderId);
    }
}
