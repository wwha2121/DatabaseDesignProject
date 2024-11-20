package com.wc.watchu.service;

import com.wc.watchu.dto.EpisodeDTO;
import com.wc.watchu.entity.EpisodeEntity;
import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.repository.EpisodeRepository;
import com.wc.watchu.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // Spring 관리 객체
@RequiredArgsConstructor // final 멤버 변수를 위한 생성자 자동 생성
public class AddEpisodeService {

    private final EpisodeRepository episodeRepository; // Episode 엔티티 저장을 위한 Repository
    private final ContentsRepository contentsRepository; // Contents 엔티티 저장을 위한 Repository

    // 에피소드 저장 메소드
    public void save(EpisodeDTO episodeDTO) {
        // EpisodeDTO를 EpisodeEntity로 변환
        EpisodeEntity episodeEntity = EpisodeEntity.toEpisodeEntity(episodeDTO);

        // EpisodeEntity를 데이터베이스에 저장
        episodeRepository.save(episodeEntity);
    }
}
