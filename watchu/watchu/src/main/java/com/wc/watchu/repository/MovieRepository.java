package com.wc.watchu.repository;

import com.wc.watchu.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    boolean existsByContent_ContentsId(Long contentsId);
    List<MovieEntity> findByContent_ContentsId(Long contentsId);

    @Query("SELECT m FROM MovieEntity m ORDER BY m.views DESC")
    List<MovieEntity> findTop5ByViewsDesc();
}