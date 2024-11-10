package com.wc.watchu.service;

import com.wc.watchu.dto.ContentsDTO;
import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddContentsService {

    private final ContentsRepository contentsRepository;

    // 콘텐츠 추가 메서드
    public void save(ContentsDTO contentsDTO) {
        // 콘텐츠 DTO를 엔티티로 변환
        ContentsEntity contentsEntity = ContentsEntity.toContentsEntity(contentsDTO);
        // 콘텐츠 엔티티를 데이터베이스에 저장
        contentsRepository.save(contentsEntity);
    }
}
