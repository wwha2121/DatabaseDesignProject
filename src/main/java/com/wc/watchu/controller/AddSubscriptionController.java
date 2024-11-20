package com.wc.watchu.controller;

import com.wc.watchu.dto.SubscriptionDTO;
import com.wc.watchu.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AddSubscriptionController {
    private final SubscriptionService subscriptionService;

    // 구독 추가 페이지를 보여주는 GET 요청
    @GetMapping("/subscription")
    public String subscriptionPage() {
        return "sub/subscription/subscription"; // 구독 추가 폼 페이지 (HTML)
    }

    // 구독 추가 폼에서 제출된 데이터를 처리하는 POST 요청
    @PostMapping("/subscription")
    public String save(@ModelAttribute SubscriptionDTO subscriptionDTO) {

        System.out.println("SubscriptionController");
        System.out.println("subscriptionDTO = " + subscriptionDTO);

        // 서비스로 전달하여 구독을 저장
        subscriptionService.save(subscriptionDTO);

        return "index";
    }
}