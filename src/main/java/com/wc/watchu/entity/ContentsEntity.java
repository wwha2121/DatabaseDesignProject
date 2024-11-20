package com.wc.watchu.entity;

import jakarta.persistence.*;
import com.wc.watchu.dto.ContentsDTO;
import lombok.*;

import java.sql.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "contents")
public class ContentsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contentsId; // contents_id (자동 증가)

    @Column(length = 36)
    private String contentsCategory; // contents_category

    @Column(nullable = false, length = 100)
    private String contentsName; // contents_name

    @Column(columnDefinition = "TEXT", nullable = false)
    private String contentsDescription; // contents_description

    @Column
    private Date contentsRelease; // contents_release

    @Column(length = 50)
    private String contentsGenre; // contents_genre

    @Column(length = 50)
    private String contentsCountry; // contents_country

    @Column
    private String contentsPoster; // contents_poster

    @Builder
    public static ContentsEntity toContentsEntity(ContentsDTO contentsDTO) {
        ContentsEntity contentsEntity = new ContentsEntity();

        contentsEntity.setContentsId(contentsDTO.getContentsId());
        contentsEntity.setContentsCategory(contentsDTO.getContentsCategory());
        contentsEntity.setContentsName(contentsDTO.getContentsName());
        contentsEntity.setContentsDescription(contentsDTO.getContentsDescription());
        contentsEntity.setContentsRelease(contentsDTO.getContentsRelease());
        contentsEntity.setContentsGenre(contentsDTO.getContentsGenre());
        contentsEntity.setContentsCountry(contentsDTO.getContentsCountry());
        contentsEntity.setContentsPoster(contentsDTO.getContentsPoster());

        return contentsEntity;
    }
}
