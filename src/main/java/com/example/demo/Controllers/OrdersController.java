package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.orders;
import com.example.demo.repository.OrdersRepository;

@RestController
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersRepository ordersRepository;

    public OrdersController(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @PostMapping("/placeOrder")
    public String placeOrder(@RequestBody orders order) {
        ordersRepository.save(order);
        return "Order Placed";
    }
}
