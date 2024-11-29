package com.wc.watchu.dto;

public class ReviewRequestDTO {
    private String email; // 사용자 이메일
    private String reviewContext; // 댓글 내용

    // Getter/Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getReviewContext() {
        return reviewContext;
    }

    public void setReviewContext(String reviewContext) {
        this.reviewContext = reviewContext;
    }
}
