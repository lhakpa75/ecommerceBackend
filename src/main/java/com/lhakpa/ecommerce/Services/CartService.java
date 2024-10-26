package com.lhakpa.ecommerce.Services;

import com.lhakpa.ecommerce.Entity.Cart;
import com.lhakpa.ecommerce.Entity.CartItem;
import com.lhakpa.ecommerce.Entity.Product;
import com.lhakpa.ecommerce.Entity.User;
import com.lhakpa.ecommerce.Repository.CartRepository;
import com.lhakpa.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    // Add items to the cart
    public Cart addToCart(User user, List<CartItem> items) {
        Cart cart = cartRepository.findByUser(user);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
        }
        cart.getItems().addAll(items);

        return cartRepository.save(cart);
    }

    // Get the user's cart
    public Cart getCart(User user) {
        return cartRepository.findByUser(user);
    }

    // Clear the cart after placing an order
    public void clearCart(Cart cart) {
        cart.getItems().clear();
        cartRepository.save(cart);
    }
}
