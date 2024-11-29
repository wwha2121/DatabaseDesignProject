package com.wc.watchu.repository;

import com.wc.watchu.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    boolean existsByContent_ContentsId(int contentsId);
    List<MovieEntity> findByContent_ContentsId(int contentsId);

    @Query("SELECT m FROM MovieEntity m ORDER BY m.views DESC")
    List<MovieEntity> findTop5ByViewsDesc();
}