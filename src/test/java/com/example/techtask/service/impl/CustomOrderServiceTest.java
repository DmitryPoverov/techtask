package com.example.techtask.service.impl;

import com.example.techtask.model.Order;
import com.example.techtask.repository.CustomOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomOrderServiceTest {

    private static final int ID_EIGHT = 8;
    private static final int ID_FOUR = 4;

    @Autowired
    private CustomOrderRepository customOrderRepository;

    @Test
    public void testFindNewestOrderWithMoreThanOneItem() {
        Order order = customOrderRepository.findMoreThanOneItemNewestOrder();
        assertNotNull(order);
        assertEquals(ID_FOUR, order.getId());
    }

    @Test
    public void testFindOrdersFromActiveUsersSortedByCreationDate() {
        List<Order> orders = customOrderRepository.findActiveUsersCreateDateSortedOrders();
        assertNotNull(orders);
        assertEquals(ID_EIGHT, orders.get(0).getId());
    }
}