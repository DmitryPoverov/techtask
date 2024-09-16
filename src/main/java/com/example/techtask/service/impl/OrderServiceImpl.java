package com.example.techtask.service.impl;

import com.example.techtask.model.Order;
import com.example.techtask.repository.CustomOrderRepository;
import com.example.techtask.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final CustomOrderRepository orderRepository;

    @Override
    public Order findOrder() {
        return orderRepository.findMoreThanOneItemNewestOrder();
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findActiveUsersCreateDateSortedOrders();
    }
}
