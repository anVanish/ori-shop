package com.vanish.javaweb.DAO.Order;

import com.vanish.javaweb.Entities.Cart;
import com.vanish.javaweb.Entities.Order;
import com.vanish.javaweb.JPAConfig.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class OrderDAOImpl implements IOrderDAO {
    @Override
    public List<Order> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            return enma.createQuery(
                    "SELECT DISTINCT o FROM Order o " +
                            "LEFT JOIN FETCH o.orderItems " +
                            "ORDER BY o.orderId DESC",
                    Order.class
            ).getResultList();
        } finally {
            enma.close();
        }
    }

    @Override
    public List<Order> findAllByUser(int userId) {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            return enma.createQuery(
                            "SELECT DISTINCT o FROM Order o " +
                                    "LEFT JOIN FETCH o.orderItems " +
                                    "WHERE o.user.userId = :userId " +
                                    "ORDER BY o.orderId DESC",
                            Order.class
                    ).setParameter("userId", userId)
                    .getResultList();
        } finally {
            enma.close();
        }
    }

    @Override
    public Order findById(int orderId) {
        EntityManager enma = JPAConfig.getEntityManager();
        try {
            return enma.createQuery(
                            "SELECT DISTINCT o FROM Order o LEFT JOIN FETCH o.orderItems " +
                                    "WHERE o.orderId = :orderId",
                            Order.class)
                    .setParameter("orderId", orderId)
                    .getSingleResult();
        } finally {
            enma.close();
        }
    }

    @Override
    public void insert(Order order) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(order);
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
    public void updateStatus(int orderId, String status) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction tx = enma.getTransaction();

        try {
            tx.begin();
            enma.createNamedQuery("Order.updateStatus")
                    .setParameter("status", status)
                    .setParameter("orderId", orderId)
                    .executeUpdate();
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            enma.close();
        }
    }

    @Override
    public void delete(int orderId) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            Order order = enma.find(Order.class, orderId);
            if (order != null) {
                enma.remove(order);
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
