package com.vanish.javaweb.DAO.Cart;

import com.vanish.javaweb.Entities.Cart;

import java.util.List;

public interface ICartDAO {
    List<Cart> findAllByUser(int userId);

    Cart findById(int cartId);

    Cart findByUserAndProduct(int userId, int productId);

    void insert(Cart cart);

    void update(Cart cart);

    void delete(int cartId);

}
