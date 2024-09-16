package com.example.techtask.repository;

import com.example.techtask.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomUserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public User findMaxDeliveredSumIn2003User() {
/*
        SELECT u
        FROM users u
                 JOIN orders o ON u.id = o.user_id
        WHERE o.order_status = 'DELIVERED'
          AND EXTRACT(YEAR FROM o.created_at) = 2003
        GROUP BY u.id
        ORDER BY SUM(o.price * o.quantity) DESC;
*/
        String queryString = "SELECT u FROM User u JOIN Order o ON u.id = o.userId " +
                "WHERE o.orderStatus = 'DELIVERED' AND EXTRACT(YEAR FROM o.createdAt) = 2003 " +
                "GROUP BY u.id ORDER BY SUM(o.price * o.quantity) DESC";
        TypedQuery<User> query = entityManager.createQuery(queryString, User.class);

        return query
                .setMaxResults(1)
                .getSingleResult();
    }

    public List<User> findPaidOrdersIn2010Users() {
/*
        SELECT DISTINCT u
        FROM users u
                 JOIN orders o ON u.id = o.user_id
        WHERE o.order_status = 'PAID'
          AND EXTRACT(YEAR FROM o.created_at) = 2010;
*/
        String queryStr = "SELECT DISTINCT u FROM User u JOIN Order o ON u.id = o.userId " +
                "WHERE o.orderStatus = 'PAID' AND EXTRACT(YEAR FROM o.createdAt) = 2010";
        TypedQuery<User> query = entityManager.createQuery(queryStr, User.class);

        return query.getResultList();
    }
}
