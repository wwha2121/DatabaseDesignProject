package com.wc.watchu.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
