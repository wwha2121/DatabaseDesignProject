package com.wc.watchu.entity;

import jakarta.persistence.*;
import com.wc.watchu.dto.SubscriptionDTO;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "subscription")
public class SubscriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subId;      // 구독 ID

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private SubscriptionStateEnum subState;  // 구독 상태 (SUB, NONSUB)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private SubscriptionTypeEnum subType;   // 구독 유형 (SINGLE, GROUP)

    @Column(nullable = false)
    private int subMax;        // 최대 수

    @Column(nullable = false)
    private Date subPeriod;    // 구독 기간

    // SubscriptionDTO를 SubscriptionEntity로 변환하는 정적 메서드
    @Builder
    public static SubscriptionEntity toSubscriptionEntity(SubscriptionDTO subscriptionDTO) {
        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();

        subscriptionEntity.setSubId(subscriptionDTO.getSubId());
        subscriptionEntity.setSubState(subscriptionDTO.getSubState());  // 바로 enum 타입을 설정
        subscriptionEntity.setSubType(subscriptionDTO.getSubType());
        subscriptionEntity.setSubMax(subscriptionDTO.getSubMax());
        subscriptionEntity.setSubPeriod(subscriptionDTO.getSubPeriod());

        return subscriptionEntity;
    }
}
