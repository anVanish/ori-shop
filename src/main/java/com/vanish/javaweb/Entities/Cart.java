package com.vanish.javaweb.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Cart")
@NamedQuery(name = "Cart.findAllByUser", query = "SELECT c FROM Cart c WHERE c.user.userId = :userId")
@NamedQuery(name = "Cart.findByUserAndProduct", query = "SELECT c FROM Cart c WHERE c.user.userId = :userId AND c.product.productId = :productId")
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    @Column(nullable = false, columnDefinition = "int default 1")
    private int quantity = 1;

    //constructor
    public Cart() {
    }

    public Cart(Builder builder) {
        this.cartId = builder.cartId;
        this.user = builder.user;
        this.product = builder.product;
        this.quantity = builder.quantity;
    }


    //getter
    public int getCartId() {
        return cartId;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    //setter
    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }

    //builder
    public static class Builder {
        private int cartId;
        private Product product;
        private User user;
        private int quantity = 1;

        public Builder setCartId(int cartId) {
            this.cartId = cartId;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Cart build() {
            return new Cart(this);
        }
    }
}
