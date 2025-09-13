package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.orders;
import com.example.demo.repository.OrdersRepository;

@CrossOrigin(origins = {"http://localhost:5173"}, methods = {RequestMethod.POST}, allowCredentials = "true")
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
