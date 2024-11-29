package com.wc.watchu.repository;

import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentsRepository extends JpaRepository<ContentsEntity, Integer>
{
    // 카테고리로 콘텐츠를 조회 (예: MOVIE, SERIES)
    List<ContentsEntity> findByContentsCategoryOrderByContentsIdDesc(String contentsCategory);

    // 콘텐츠 ID로 단일 콘텐츠 조회
    ContentsEntity findByContentsId(int contentsId);
}