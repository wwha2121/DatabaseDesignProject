package com.wc.watchu.dto;

import com.wc.watchu.entity.ContentsEntity;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ContentsDTO {
    private Long contentsId; // 콘텐츠 ID
    private String contentsCategory; // 콘텐츠 카테고리
    private String contentsName; // 콘텐츠 이름
    private String contentsDescription; // 콘텐츠 설명
    private Date contentsRelease; // 콘텐츠 출시 연도
    private String contentsGenre; // 콘텐츠 장르
    private String contentsCountry; // 콘텐츠 국가
    private String contentsPoster; // 콘텐츠 포스터

    // ContentsEntity를 ContentsDTO로 변환하는 정적 메서드
    public static ContentsDTO toContentsDTO(ContentsEntity contentsEntity) {
        ContentsDTO contentsDTO = new ContentsDTO();
        contentsDTO.setContentsId(contentsEntity.getContentsId());
        contentsDTO.setContentsCategory(contentsEntity.getContentsCategory());
        contentsDTO.setContentsName(contentsEntity.getContentsName());
        contentsDTO.setContentsDescription(contentsEntity.getContentsDescription());
        contentsDTO.setContentsRelease(contentsEntity.getContentsRelease());
        contentsDTO.setContentsGenre(contentsEntity.getContentsGenre());
        contentsDTO.setContentsCountry(contentsEntity.getContentsCountry());
        contentsDTO.setContentsPoster(contentsEntity.getContentsPoster());

        return contentsDTO;
    }
}