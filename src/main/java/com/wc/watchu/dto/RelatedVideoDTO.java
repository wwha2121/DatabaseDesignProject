package com.wc.watchu.dto;

import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.entity.RelatedVideoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class RelatedVideoDTO {

    private int contentsId;
    private String videoPath;
    private String description;

    public static RelatedVideoDTO toRelatedVideoDTO(RelatedVideoEntity relatedVideoEntity) {

        RelatedVideoDTO relatedVideoDTO= new  RelatedVideoDTO();
        relatedVideoDTO.setContentsId(relatedVideoEntity.getContents().getContentsId());
        relatedVideoDTO.setVideoPath(relatedVideoEntity.getVideoPath());



        return relatedVideoDTO;
    }
}
