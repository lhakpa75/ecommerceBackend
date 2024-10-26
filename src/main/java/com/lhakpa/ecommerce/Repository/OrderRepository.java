package com.lhakpa.ecommerce.Repository;

import com.lhakpa.ecommerce.Entity.CustomerOrder;
import com.lhakpa.ecommerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<CustomerOrder, Long> {
    List<CustomerOrder> findByUser(User user);
}
