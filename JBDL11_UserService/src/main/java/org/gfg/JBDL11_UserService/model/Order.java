package org.gfg.JBDL11_UserService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    int orderId;
    String productName;
    String productDescription;
    double price;

}
