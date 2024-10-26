package com.lhakpa.ecommerce.Services;

import com.lhakpa.ecommerce.Entity.CustomerOrder;
import com.lhakpa.ecommerce.Entity.OrderItem;
import com.lhakpa.ecommerce.Entity.Product;
import com.lhakpa.ecommerce.Entity.User;
import com.lhakpa.ecommerce.Repository.CustomerOrderRepository;
import com.lhakpa.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private CustomerOrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public CustomerOrder createOrder(User user, List<OrderItem> items) {
        CustomerOrder order = new CustomerOrder();
        order.setUser(user);
        order.setItems(new ArrayList<>());

        for (OrderItem item : items) {
            // Fetch the product by ID
            Product product = productRepository.findById(item.getProduct().getId()).orElse(null);
            if (product != null) {
                item.setProduct(product);  // Set the product entity
                order.getItems().add(item); // Add item to the order
            }
        }

        // Save the order in the database
        return orderRepository.save(order);
    }
    public CustomerOrder createOrder(User user, List<OrderItem> items) {
        CustomerOrder order = new CustomerOrder();
        order.setUser(user);
        order.setItems(new ArrayList<>());

        for (OrderItem item : items) {
            Product product = productRepository.findById(item.getProduct().getId()).orElse(null);
            if (product != null) {
                item.setProduct(product);  // Set the product entity
                item.setOrder(order);  // Set the reference to the current order
                order.getItems().add(item); // Add item to the order
            }
        }

        // Save the order in the database
        return orderRepository.save(order);
    }

    // Other methods like getOrderHistory, etc.
}
