package com.wc.watchu.dto;

import com.mysql.cj.log.Log;
import com.wc.watchu.entity.ReviewEntity;

import com.wc.watchu.entity.SignUpEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ReviewDTO {

    private int memberId;
    private String reviewContext;
    private String reviewName;

    public static ReviewDTO toReviewDTO(ReviewEntity reviewEntity) {

        SignUpEntity signEntity = new SignUpEntity();
        LoginDTO loginDTO = new LoginDTO();

        ReviewDTO reviewDTO = new ReviewDTO();

        System.out.println("login emial:");
        reviewDTO.setMemberId(signEntity.getMemberId());
        reviewDTO.setReviewName(signEntity.getMemberName());
        reviewDTO.setReviewContext(reviewEntity.getReviewContext());
        reviewDTO.setReviewName(loginDTO.getName());
        return reviewDTO;
    }

}


