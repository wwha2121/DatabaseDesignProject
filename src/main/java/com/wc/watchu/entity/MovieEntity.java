package com.wc.watchu.entity;

import com.wc.watchu.dto.MovieDTO;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId; // 영화 ID (자동 증가)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contents_id") // 외래키
    private ContentsEntity content; // 콘텐츠와 연결 (ManyToOne 관계)

    @Column(nullable = false)
    private int duration; // 영화 길이 (분)

    @Column(length = 255)
    private String imgPath; // 포스터 이미지 경로

    @Column(length = 255)
    private String videoPath; // 영상 경로

    @Column
    private int views; // 조회수

    public Long getContentsId() {
        if (content != null) {
            return content.getContentsId(); // ContentsEntity의 contentsId를 반환
        }
        return null; // content가 없으면 null 반환
    }

    @Builder
    public static MovieEntity toMovieEntity(MovieDTO movieDTO, ContentsEntity contentEntity) {
        MovieEntity movieEntity = new MovieEntity();


        movieEntity.setMovieId(movieDTO.getMovieId());
        movieEntity.setContent(contentEntity);  // ContentsEntity를 넣어줌
        movieEntity.setDuration(movieDTO.getMovieDuration());
        movieEntity.setImgPath(movieDTO.getMovieImgPath());
        movieEntity.setVideoPath(movieDTO.getMovieVideoPath());
        movieEntity.setViews(movieDTO.getMovieViews());

        return movieEntity;
    }
}