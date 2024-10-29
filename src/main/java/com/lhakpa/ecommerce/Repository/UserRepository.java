package com.lhakpa.ecommerce.Repository;

import com.lhakpa.ecommerce.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Additional query methods can be defined here
}
