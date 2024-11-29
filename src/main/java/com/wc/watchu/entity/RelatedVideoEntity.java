package com.wc.watchu.entity;

import com.wc.watchu.dto.RelatedVideoDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "RELATED_VIDEO")
@Getter
@Setter
@NoArgsConstructor
public class RelatedVideoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // contents_id는 AUTO_INCREMENT
    @Column(name = "contents_id")
    private int contentsId;

    @Column(name = "video_path", length = 255, nullable = true)
    private String videoPath;

    @Column(name = "description", length = 100)
    private String description;

    // Many-to-One 관계 설정: RelatedVideo는 Contents에 종속적
    @ManyToOne
    @JoinColumn(name = "contents_id", insertable = false, updatable = false) // 외래 키 매핑
    private ContentsEntity contents;

    // 추가적인 유틸 메서드들 (필요하면 작성)

    @Builder
    public static RelatedVideoEntity toRelatedVideoEntity(RelatedVideoDTO relatedVideoDTO, ContentsEntity contentsEntity) {
        RelatedVideoEntity relatedVideoEntity = new RelatedVideoEntity();

        relatedVideoEntity.setContentsId(contentsEntity.getContentsId());
        relatedVideoEntity.setVideoPath(relatedVideoDTO.getVideoPath());
        relatedVideoEntity.setDescription(relatedVideoDTO.getDescription());
        relatedVideoEntity.setContents(contentsEntity); // Many-to-One 관계 설정

        return relatedVideoEntity;
    }


}
