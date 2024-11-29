package com.wc.watchu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentsRequestDTO {
    private ContentsDTO contentsDTO;
    private RelatedVideoDTO relatedVideoDTO;
}

