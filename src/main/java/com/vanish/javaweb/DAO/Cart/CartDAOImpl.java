package com.vanish.javaweb.DAO.Cart;

import com.vanish.javaweb.Entities.Cart;
import com.vanish.javaweb.Entities.User;
import com.vanish.javaweb.JPAConfig.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class CartDAOImpl implements ICartDAO {
    @Override
    public List<Cart> findAllByUser(int userId) {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            TypedQuery<Cart> query = enma.createNamedQuery("Cart.findAllByUser", Cart.class)
                    .setParameter("userId", userId);
            return query.getResultList();
        } finally {
            enma.close();
        }
    }

    @Override
    public Cart findById(int cartId) {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            return enma.find(Cart.class, cartId);
        } finally {
            enma.close();
        }
    }

    @Override
    public Cart findByUserAndProduct(int userId, int productId) {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            return enma.createNamedQuery("Cart.findByUserAndProduct", Cart.class)
                    .setParameter("userId", userId)
                    .setParameter("productId", productId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            enma.close();
        }
    }

    @Override
    public void insert(Cart cart) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(cart);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void update(Cart cart) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(cart);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void delete(int cartId) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            Cart cart = enma.find(Cart.class, cartId);
            if (cart != null) {
                enma.remove(cart);
            } else {
                throw new Exception("Không tìm thấy");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        } finally {
            enma.close();
        }
    }
}
