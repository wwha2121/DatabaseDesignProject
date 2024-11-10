package com.wc.watchu.service;

import com.wc.watchu.dto.EpisodeDTO;
import com.wc.watchu.entity.EpisodeEntity;
import com.wc.watchu.repository.EpisodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EpisodeService {

    private final EpisodeRepository episodeRepository;

    // 콘텐츠 ID에 해당하는 모든 에피소드 목록 가져오기
    public List<EpisodeDTO> getEpisodesByContent(Long contentsId) {
        List<EpisodeEntity> episodeEntities = episodeRepository.findByContentsId(contentsId);
        return episodeEntities.stream()
                .map(EpisodeDTO::toEpisodeDTO) // 엔티티를 DTO로 변환
                .collect(Collectors.toList());
    }
}