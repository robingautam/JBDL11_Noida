package org.gfg.JBDL11_UserService.service;

import org.gfg.JBDL11_UserService.model.Order;
import org.gfg.JBDL11_UserService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    static List<User> userList;

    static {
        User user1 = new User(1, "John Doe", "johndoe@gmail.com", "123 Main St");
        User user2 = new User(2, "Jane Smith", "janesmith@gmail.com", "456 Elm St");
        User user3 = new User(3, "Bob Johnson", "bobjohnson@gmail.com", "789 Oak St");
        User user4 = new User(4, "Alice Brown", "alicebrown@gmail.com", "321 Pine St");
        userList = List.of(user1, user2, user3, user4);
    }


    @Autowired
    RestTemplate restTemplate;

    public User getUserById(int id){
        User finalUser = null;
        for (User user : userList) {
            if(user.getId() == id){
                finalUser = user;
                break;
            }
        }
        // Call the order service to get the orders for the user and set it in the user object

        List<Order> orderList =  restTemplate.getForObject("http://localhost:8081/order-service/orders/"+id, List.class);
        finalUser.setOrderList(orderList);
        return finalUser;
    }

}
