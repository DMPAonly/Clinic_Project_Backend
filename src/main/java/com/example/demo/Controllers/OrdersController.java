package com.example.demo.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Configurations.PaymentConfig;
import com.example.demo.models.orders;
import com.example.demo.repository.OrdersRepository;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersRepository ordersRepository;
    private final PaymentConfig paymentConfig;

    public OrdersController(OrdersRepository ordersRepository, PaymentConfig paymentConfig) {
        this.ordersRepository = ordersRepository;
        this.paymentConfig = paymentConfig;
    }

    @GetMapping("getOrders")
    public List<orders> getOrders() {
        return ordersRepository.findAll();
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody orders order) {
        if(order.getId() == null || order.getId().isEmpty()){
            order.setId(UUID.randomUUID().toString());
        }
        String orderId = order.getId();
        int orderAmount = order.getAmount();
        return paymentConfig.initiatePayment(orderId, orderAmount);
        //ordersRepository.save(order);
        //return "Order Placed";
    }
}
