package com.wc.watchu.repository;

import com.wc.watchu.entity.SignUpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpEntity, Long>
{
    SignUpEntity findByEmail(String email);
}