package com.wc.watchu.dto;

import com.wc.watchu.entity.MovieEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieDTO {
    private int movieId; // 영화 ID
    private int contentsId; // 콘텐츠 ID (ForeignKey)
    private int movieDuration; // 영화 길이 (분)
    private String movieImgPath; // 포스터 이미지 경로
    private String movieVideoPath; // 영상 경로
    private int movieViews; // 조회수

    // MovieDTO를 MovieEntity 엔티티로 변환하는 정적 메서드
    public static MovieDTO toMovieDTO(MovieEntity movieEntity) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setMovieId(movieEntity.getMovieId());
        movieDTO.setContentsId(movieEntity.getContentsId());
        movieDTO.setMovieDuration(movieEntity.getDuration());
        movieDTO.setMovieImgPath(movieEntity.getImgPath());
        movieDTO.setMovieVideoPath(movieEntity.getVideoPath());
        movieDTO.setMovieViews(movieEntity.getViews());

        return movieDTO;
    }
}
