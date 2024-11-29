package com.wc.watchu.dto;

import com.wc.watchu.entity.ReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDTO {
    private String name;   // 멤버 이름
    private String reviewContext; // 리뷰 내용

    // 정적 팩토리 메서드를 통해 Entity에서 DTO로 변환
    public static ReviewResponseDTO  fromEntity(ReviewEntity reviewEntity, String memberName) {
        return new ReviewResponseDTO(memberName, reviewEntity.getReviewContext());
    }
}
