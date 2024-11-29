package com.wc.watchu.repository;

import com.wc.watchu.entity.EpisodeEntity;
import com.wc.watchu.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
    List<ReviewEntity> findByContents_ContentsId(Long contentsId);
}