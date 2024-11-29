package com.wc.watchu.service;

import com.wc.watchu.dto.ContentsDTO;
import com.wc.watchu.dto.ContentsRequestDTO;
import com.wc.watchu.dto.RelatedVideoDTO;
import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.entity.RelatedVideoEntity;
import com.wc.watchu.repository.ContentsRepository;
import com.wc.watchu.repository.RelatedVideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddContentsService {

    private final ContentsRepository contentsRepository;

    private RelatedVideoRepository relatedVideoRepository; // 추가
    // 콘텐츠 추가 메서드
    public void save(ContentsDTO contentsDTO) {
        // 콘텐츠 DTO를 엔티티로 변환
        ContentsEntity contentsEntity = ContentsEntity.toContentsEntity(contentsDTO);

        // 콘텐츠 엔티티를 데이터베이스에 저장
        contentsRepository.save(contentsEntity);

    }
    public ContentsRequestDTO saveAndReturn(ContentsDTO contentsDTO, RelatedVideoDTO relatedVideoDTO) {
        ContentsEntity contentsEntity = ContentsEntity.toContentsEntity(contentsDTO);
        RelatedVideoEntity relatedVideoEntity = RelatedVideoEntity.toRelatedVideoEntity(relatedVideoDTO,contentsEntity);

        contentsRepository.save(contentsEntity);
        relatedVideoRepository.save(relatedVideoEntity);

        return new ContentsRequestDTO(contentsDTO, relatedVideoDTO);
    }
}
