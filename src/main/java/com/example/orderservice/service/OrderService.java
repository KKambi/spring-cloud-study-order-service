package com.example.orderservice.service;

import com.example.orderservice.domain.Order;
import com.example.orderservice.domain.OrderRepository;
import com.example.orderservice.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderDto createOrder(OrderDto orderDto) {
        orderDto.setOrderId(UUID.randomUUID().toString());
        orderDto.setTotalPrice(orderDto.getQty() * orderDto.getUnitPrice());

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        orderRepository.save(mapper.map(orderDto, Order.class));

        return orderDto;
    }

    public OrderDto getOrderByOrderId(String orderId) {
        Order order = orderRepository.findByOrderId(orderId);
        return new ModelMapper().map(order, OrderDto.class);
    }

    public Iterable<Order> getOrdersByUserId(String userId) {
        return orderRepository.findAllByUserId(userId);
    }
}
