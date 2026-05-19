package org.gfg.JBDL11_OrderService.service;

import org.gfg.JBDL11_OrderService.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    static List<Order> orderList;
    static {
        orderList = List.of(
                new Order(1001, "Laptop", "Dell XPS 13", 999.99),
                new Order(1002, "Smartphone", "iPhone 12", 799.99),
                new Order(1003, "Headphones", "Sony WH-1000XM4", 349.99)
        );
    }

    public List<Order> getOrdersByUserId(int id){
        List<Order> orders = new ArrayList<>();

        if (id==1){
            orders = List.of(orderList.get(0));
        }else if (id==2){
            orders = List.of(orderList.get(1), orderList.get(2));
        }else if (id==3) {
            orders = List.of(orderList.get(2),orderList.get(0));
        }

        return orders;
    }
}
