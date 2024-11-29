package com.wc.watchu.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId; // 영화 ID (자동 증가)




    @ManyToOne
    @JoinColumn(name = "member_id", nullable = true) // 외래 키 매핑
    private SignUpEntity member; // MemberEntity와의 관계 정의

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contents_id", nullable = true) // 외래 키
    private ContentsEntity contents;



    @Column(name = "review_comment",nullable = true)
    private String reviewContext;

    @Column(name = "review_rating",nullable = true)
    private int reviewRating;


//
//    @Column(nullable = true)
//    private String review_registrationDate;



}

