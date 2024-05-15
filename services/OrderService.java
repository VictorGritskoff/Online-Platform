package com.example.example.services;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }

    public List<Order> getOrdersByClientId(int clientId) {
        return orderRepository.findByClientId(clientId);
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public void updateOrder(int id, Order updatedOrder) {
        if (orderRepository.existsById(id)) {
            updatedOrder.setId(id);
            orderRepository.save(updatedOrder);
        }
    }
    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
