package com.vanish.javaweb.Services.Cart;

import com.vanish.javaweb.Entities.Cart;
import com.vanish.javaweb.Entities.Product;
import com.vanish.javaweb.Entities.User;

import java.util.List;

public interface ICartService {
    List<Cart> findAllByUser(int userId);

    Cart findById(int cartId);

    void addToCart(User user, Product product);

    void deleteFromCart(int cartId);

    void increaseCartItem(Cart cart);

    void decreaseCartItem(Cart cart);

    void clearCart(int userId);
}
