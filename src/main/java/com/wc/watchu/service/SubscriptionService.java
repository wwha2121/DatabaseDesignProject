package com.wc.watchu.service;

import com.wc.watchu.dto.SubscriptionDTO;
import com.wc.watchu.entity.SubscriptionEntity;
import com.wc.watchu.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service //스프링이 관리해주는 객체 == 스프링 빈
@RequiredArgsConstructor // final 멤버변수 생성자 생성
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    // 구독 저장 메서드
    public void save(SubscriptionDTO subscriptionDTO) {
        // SubscriptionDTO를 SubscriptionEntity로 변환
        SubscriptionEntity subscriptionEntity = SubscriptionEntity.toSubscriptionEntity(subscriptionDTO);

        // 변환된 엔티티를 저장
        subscriptionRepository.save(subscriptionEntity);
    }
}
