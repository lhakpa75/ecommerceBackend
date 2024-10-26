package com.lhakpa.ecommerce.Controller;

import com.lhakpa.ecommerce.Entity.Cart;
import com.lhakpa.ecommerce.Entity.CartItem;
import com.lhakpa.ecommerce.Entity.User;
import com.lhakpa.ecommerce.Services.CartService;
import com.lhakpa.ecommerce.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    // Add items to the cart
    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@RequestParam String username, @RequestBody List<CartItem> items) {
        User user = userService.login(username); // Fetch user
        if (user == null) {
            return ResponseEntity.status(404).body(null); // Handle user not found
        }

        Cart cart = cartService.addToCart(user, items);
        return ResponseEntity.ok(cart);
    }

    // Get the user's cart
    @GetMapping("/view")
    public ResponseEntity<Cart> viewCart(@RequestParam String username) {
        User user = userService.login(username); // Fetch user
        if (user == null) {
            return ResponseEntity.status(404).body(null); // Handle user not found
        }

        Cart cart = cartService.getCart(user);
        return ResponseEntity.ok(cart);
    }
}
