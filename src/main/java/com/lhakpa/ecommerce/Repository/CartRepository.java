package com.lhakpa.ecommerce.Repository;

import com.lhakpa.ecommerce.Entity.Cart;
import com.lhakpa.ecommerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
