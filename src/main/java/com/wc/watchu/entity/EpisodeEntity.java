package com.wc.watchu.entity;

import com.wc.watchu.dto.EpisodeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "episode")
public class EpisodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long episodeId;

    @Column
    private Long contentsId; // content 필드 추가

    @Column
    private String episodeName;
    @Column
    private String description;
    @Column
    private Date episodeRelease;
    @Column
    private int episodeDuration;
    @Column
    private String imgPath;
    @Column
    private String videoPath;
    @Column
    private int views;

    // EpisodeDTO를 EpisodeEntity로 변환하는 메서드
    public static EpisodeEntity toEpisodeEntity(EpisodeDTO episodeDTO) {
        EpisodeEntity episodeEntity = new EpisodeEntity();
        episodeEntity.setContentsId(episodeDTO.getContentsId());
        episodeEntity.setEpisodeName(episodeDTO.getEpisodeName());
        episodeEntity.setDescription(episodeDTO.getDescription());
        episodeEntity.setEpisodeRelease(episodeDTO.getEpisodeRelease());
        episodeEntity.setEpisodeDuration(episodeDTO.getEpisodeDuration());
        episodeEntity.setImgPath(episodeDTO.getImgPath());
        episodeEntity.setVideoPath(episodeDTO.getVideoPath());
        episodeEntity.setViews(episodeDTO.getViews());
        return episodeEntity;
    }
}