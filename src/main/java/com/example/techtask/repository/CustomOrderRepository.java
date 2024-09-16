package com.example.techtask.repository;

import com.example.techtask.model.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomOrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Order findMoreThanOneItemNewestOrder() {
/*
        SELECT o
        FROM orders o
        WHERE o.quantity > 1
        ORDER BY o.created_at DESC;
*/
        String queryStr = "SELECT o FROM Order o WHERE o.quantity > 1 ORDER BY o.createdAt DESC";
        TypedQuery<Order> query = entityManager.createQuery(queryStr, Order.class);

        return query
                .setMaxResults(1)
                .getSingleResult();
    }

    public List<Order> findActiveUsersCreateDateSortedOrders() {
/*
        SELECT o
        FROM orders o
                 JOIN users u ON o.user_id = u.id
        WHERE u.user_status = 'ACTIVE'
        ORDER BY o.created_at;
*/
        String queryStr = "SELECT o FROM Order o JOIN User u ON o.userId = u.id " +
                "WHERE u.userStatus = 'ACTIVE' ORDER BY o.createdAt ASC";
        TypedQuery<Order> query = entityManager.createQuery(queryStr, Order.class);

        return query.getResultList();
    }
}
