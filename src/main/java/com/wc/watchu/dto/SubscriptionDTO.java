package com.wc.watchu.dto;

import com.wc.watchu.entity.SubscriptionEntity;
import com.wc.watchu.entity.SubscriptionStateEnum;
import com.wc.watchu.entity.SubscriptionTypeEnum;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SubscriptionDTO {
    private Long subId;          // 구독 ID (자동 생성되는 값)
    private SubscriptionStateEnum subState;     // 구독 상태 (SUB, NONSUB)
    private SubscriptionTypeEnum subType;      // 구독 유형 (SINGLE, GROUP)
    private int subMax;          // 최대 수
    private Date subPeriod;      // 구독 기간 (날짜)

    // SubscriptionEntity를 SubscriptionDTO로 변환하는 정적 메서드
    public static SubscriptionDTO toSubscriptionDTO(SubscriptionEntity subscriptionEntity) {

        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        subscriptionDTO.setSubId(subscriptionEntity.getSubId());
        subscriptionDTO.setSubState(subscriptionEntity.getSubState());
        subscriptionDTO.setSubType(subscriptionEntity.getSubType());
        subscriptionDTO.setSubMax(subscriptionEntity.getSubMax());
        subscriptionDTO.setSubPeriod(subscriptionEntity.getSubPeriod());

        return subscriptionDTO;
    }
}
