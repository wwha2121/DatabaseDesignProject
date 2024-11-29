package com.wc.watchu.service;

import com.mysql.cj.log.Log;
import com.wc.watchu.dto.LoginDTO;
import com.wc.watchu.dto.ReviewDTO;
import com.wc.watchu.dto.ReviewResponseDTO;
import com.wc.watchu.entity.ReviewEntity;
import com.wc.watchu.entity.SignUpEntity;
import com.wc.watchu.repository.ReviewRepository;
import com.wc.watchu.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;


    @Autowired
    private SignUpRepository signUpRepository;


    public List<ReviewResponseDTO> getAllReviews() {
        return reviewRepository.findAll().stream()
                .map(review -> {
                    // 리뷰 작성자의 ID를 이용해 SignUpEntity를 조회
                    SignUpEntity member = signUpRepository.findById(review.getMember().getMemberId()).orElse(null);

                    // 멤버 이름 가져오기
                    String memberName = (member != null) ? member.getMemberName() : "Unknown";

                    // ReviewEntity와 멤버 이름을 사용해 DTO 생성
                    return ReviewResponseDTO.fromEntity(review, memberName);
                })
                .collect(Collectors.toList());
    }

    public ReviewEntity createReviewEntity(ReviewDTO reviewDTO, LoginDTO loginDTO, SignUpEntity signUpEntity) {
        ReviewEntity reviewEntity = new ReviewEntity();

        // 로그인 정보와 회원 정보로 엔티티 값 설정
        reviewDTO.setReviewName(signUpEntity.getMemberName()); // 회원 이름
        reviewEntity.setReviewContext(reviewDTO.getReviewContext()); // 댓글 내용

        return reviewEntity;
    }

    public void addReview(SignUpEntity signUpEntity,String comment) {
        // MemberEntity를 가져와 ReviewEntity를 생성


        // 로그인된 사용자 ID로 회원 정보 조회


        ReviewEntity reviewEntity = new ReviewEntity();




        System.out.println("sign이랑 review");
         System.out.println(signUpEntity);
        reviewEntity.setReviewContext(comment);
        reviewEntity.setMember(signUpEntity);
        reviewRepository.save(reviewEntity);
    }

}
