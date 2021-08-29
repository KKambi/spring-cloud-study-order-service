package com.example.orderservice.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findByOrderId(String orderId);
    Iterable<Order> findAllByUserId(String userId);
}
