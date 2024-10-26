package com.lhakpa.ecommerce.Controller;

import com.lhakpa.ecommerce.Entity.CustomerOrder;
import com.lhakpa.ecommerce.Entity.OrderItem;
import com.lhakpa.ecommerce.Entity.User;
import com.lhakpa.ecommerce.Services.OrderService;
import com.lhakpa.ecommerce.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    // Create a new order
    @PostMapping("/create")
    public ResponseEntity<CustomerOrder> createOrder(@RequestParam String username, @RequestBody List<OrderItem> items) {
        User user = userService.login(username); // Fetch user
        if (user == null) {
            return ResponseEntity.status(404).body(null); // Handle user not found
        }

        CustomerOrder order = orderService.createOrder(user, items);
        return ResponseEntity.ok(order);
    }

    // Other methods like getOrderHistory
}
