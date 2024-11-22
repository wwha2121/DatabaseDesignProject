package com.wc.watchu.repository;

import com.wc.watchu.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {
}
