package com.lhakpa.ecommerce.Repository;

import com.lhakpa.ecommerce.Entity.CustomerOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder, Long> {
}
