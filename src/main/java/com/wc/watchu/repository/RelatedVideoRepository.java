package com.wc.watchu.repository;

import com.wc.watchu.entity.RelatedVideoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelatedVideoRepository extends JpaRepository<RelatedVideoEntity, Integer> {
    List<RelatedVideoEntity> findByContentsId(int contentsId);
}
