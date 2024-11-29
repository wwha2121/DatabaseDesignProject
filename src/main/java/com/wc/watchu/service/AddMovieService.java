package com.wc.watchu.service;

import com.wc.watchu.dto.MovieDTO;
import com.wc.watchu.entity.MovieEntity;
import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.repository.MovieRepository;
import com.wc.watchu.repository.ContentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // Spring 관리 객체
@RequiredArgsConstructor // final 멤버 변수를 위한 생성자 자동 생성
public class AddMovieService {

    private final MovieRepository movieRepository; // Movie 엔티티 저장을 위한 Repository
    private final ContentsRepository contentsRepository; // Contents 엔티티 저장을 위한 Repository

    // 콘텐츠 저장 메소드
    public void save(MovieDTO movieDTO) {
        // ContentsDTO에서 ContentsEntity로 변환하여 가져오기
        ContentsEntity contentEntity = contentsRepository.findById(movieDTO.getContentsId())
                .orElseThrow(() -> new RuntimeException("콘텐츠를 찾을 수 없습니다."));

        // 콘텐츠 ID가 이미 MovieEntity에 존재하는지 확인
        boolean isMovieExist = movieRepository.existsByContent_ContentsId(movieDTO.getContentsId());
        if (isMovieExist) {
            throw new RuntimeException("이 콘텐츠에 해당하는 영화 영상이 이미 존재합니다.");
        }

        // MovieDTO를 MovieEntity로 변환
        MovieEntity movieEntity = MovieEntity.toMovieEntity(movieDTO, contentEntity);

        // MovieEntity를 데이터베이스에 저장
        movieRepository.save(movieEntity);
    }
}
