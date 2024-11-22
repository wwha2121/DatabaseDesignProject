package com.wc.watchu.repository;

import com.wc.watchu.entity.ContentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentsRepository extends JpaRepository<ContentsEntity, Long>
{
    // 카테고리로 콘텐츠를 조회 (예: MOVIE, SERIES)
    List<ContentsEntity> findByContentsCategoryOrderByContentsIdDesc(String contentsCategory);

    // 콘텐츠 ID로 단일 콘텐츠 조회
    ContentsEntity findByContentsId(Long contentsId);

    // 모든 콘텐츠를 조회 (카테고리 구분 없이)
    List<ContentsEntity> findAllByOrderByContentsIdDesc(); // 새로운 메서드 추가
}