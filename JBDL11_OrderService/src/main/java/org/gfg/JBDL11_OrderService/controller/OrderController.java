package org.gfg.JBDL11_OrderService.controller;

import org.gfg.JBDL11_OrderService.model.Order;
import org.gfg.JBDL11_OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order-service")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/orders/{id}")
    public List<Order> getOrdersByUserId(@PathVariable("id") int id){
        return orderService.getOrdersByUserId(id);
    }
}
