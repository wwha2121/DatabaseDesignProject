package com.wc.watchu.controller;

import com.wc.watchu.dto.LoginDTO;
import com.wc.watchu.dto.ReviewDTO;
import com.wc.watchu.dto.ReviewRequestDTO;
import com.wc.watchu.dto.ReviewResponseDTO;
import com.wc.watchu.entity.ReviewEntity;
import com.wc.watchu.entity.SignUpEntity;
import com.wc.watchu.repository.SignUpRepository;
import com.wc.watchu.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final SignUpRepository signUpRepository;
    private final ReviewService reviewService;

    // 생성자 주입 (권장)
    @Autowired
    public ReviewController(SignUpRepository signUpRepository, ReviewService reviewService) {
        this.signUpRepository = signUpRepository;
        this.reviewService = reviewService;
    }

    // 댓글 리스트 가져오기
    @GetMapping
    public List<ReviewResponseDTO> getAllReviews() {
        return reviewService.getAllReviews();
    }


    // 댓글 등록
    @PostMapping
    public String addReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        // 이메일 처리
        String rawEmail = reviewRequestDTO.getEmail();
        String processedEmail = rawEmail.replace("USER: ", "").trim();

        // SignUpEntity 조회
        SignUpEntity member = signUpRepository.findByEmail(processedEmail);

        // 검증
        if (member == null) {
            throw new RuntimeException("User not found with email: " + processedEmail);
        }

        // 리뷰 추가 처리
        reviewService.addReview(member, reviewRequestDTO.getReviewContext());
        {

            return "Review added successfully!";
        }

    }

}
