package com.wc.watchu.dto;

import com.wc.watchu.entity.EpisodeEntity;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EpisodeDTO {
    private Long episodeId; // 에피소드 ID
    private Long contentsId; // 콘텐츠 ID (ForeignKey)
    private String episodeName; // 에피소드 이름
    private String description; // 에피소드 설명
    private Date episodeRelease; // 에피소드 개봉일 (문자열 형식)
    private int episodeDuration; // 에피소드 길이 (분)
    private String imgPath; // 에피소드 이미지 경로
    private String videoPath; // 에피소드 영상 경로
    private int views; // 조회수

    // EpisodeDTO를 EpisodeEntity 엔티티로 변환하는 정적 메서드
    public static EpisodeDTO toEpisodeDTO(EpisodeEntity episodeEntity) {
        EpisodeDTO episodeDTO = new EpisodeDTO();
        episodeDTO.setEpisodeId(episodeEntity.getEpisodeId());
        episodeDTO.setContentsId(episodeEntity.getContentsId());
        episodeDTO.setEpisodeName(episodeEntity.getEpisodeName());
        episodeDTO.setDescription(episodeEntity.getDescription());
        episodeDTO.setEpisodeRelease(episodeEntity.getEpisodeRelease()); // 날짜는 문자열로 변환
        episodeDTO.setEpisodeDuration(episodeEntity.getEpisodeDuration());
        episodeDTO.setImgPath(episodeEntity.getImgPath());
        episodeDTO.setVideoPath(episodeEntity.getVideoPath());
        episodeDTO.setViews(episodeEntity.getViews());

        return episodeDTO;
    }
}
