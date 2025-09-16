package com.vanish.javaweb.Services.Cart;

import com.vanish.javaweb.DAO.Cart.CartDAOImpl;
import com.vanish.javaweb.Entities.Cart;
import com.vanish.javaweb.Entities.Product;
import com.vanish.javaweb.Entities.User;

import java.util.List;

public class CartServiceImpl implements ICartService {
    CartDAOImpl cartDAO = new CartDAOImpl();

    @Override
    public List<Cart> findAllByUser(int userId) {
        return cartDAO.findAllByUser(userId);
    }

    @Override
    public Cart findById(int cartId) {
        return cartDAO.findById(cartId);
    }

    @Override
    public void addToCart(User user, Product product) {
        Cart existCart = cartDAO.findByUserAndProduct(user.getUserId(), product.getProductId());
        if (existCart == null) {
            //insert to cart
            Cart cart = new Cart.Builder()
                    .setUser(user)
                    .setProduct(product)
                    .build();
            cartDAO.insert(cart);
        } else {
            //increase cart
            int quantity = existCart.getQuantity();
            existCart.setQuantity(quantity + 1);
            cartDAO.update(existCart);
        }
    }

    @Override
    public void deleteFromCart(int cartId) {
        cartDAO.delete(cartId);
    }

    @Override
    public void increaseCartItem(Cart cart) {
        int quantity = cart.getQuantity();
        cart.setQuantity(quantity + 1);
        cartDAO.update(cart);
    }

    @Override
    public void decreaseCartItem(Cart cart) {
        int quantity = cart.getQuantity();
        cart.setQuantity(quantity - 1);
        if (cart.getQuantity() <= 0){
            //delete cart
            cartDAO.delete(cart.getCartId());
        } else {
            //decrease cart
            cartDAO.update(cart);
        }
    }

    @Override
    public void clearCart(int userId) {
        List<Cart> carts = cartDAO.findAllByUser(userId);
        for (Cart c: carts){
            cartDAO.delete(c.getCartId());
        }
    }
}
