package com.vanish.javaweb.DAO.Product;

import com.vanish.javaweb.Entities.Category;
import com.vanish.javaweb.Entities.Product;
import com.vanish.javaweb.JPAConfig.JPAConfig;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductDAOImpl implements IProductDAO{
    @Override
    public List<Product> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();
        TypedQuery<Product> query= enma.createNamedQuery("Product.findAll", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        EntityManager enma = JPAConfig.getEntityManager();
        return enma.find(Product.class, id);
    }

    @Override
    public void insert(Product product) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.persist(product);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        }finally {
            enma.close();
        }
    }

    @Override
    public void update(Product product) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            enma.merge(product);
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;
        }finally {
            enma.close();
        }
    }

    @Override
    public void delete(int id) {
        EntityManager enma = JPAConfig.getEntityManager();
        EntityTransaction trans = enma.getTransaction();
        try {
            trans.begin();
            Product product = enma.find(Product.class, id);
            if(product != null) {
                enma.remove(product);
            }else {
                throw new Exception("Không tìm thấy");
            }
            trans.commit();
        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        }finally {
            enma.close();
        }
    }
}
