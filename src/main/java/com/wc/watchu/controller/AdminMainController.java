package com.wc.watchu.controller;

import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.repository.ContentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class AdminMainController {

    @Autowired
    private ContentsRepository contentsRepository;

    // 모든 콘텐츠 리스트 페이지
    @GetMapping("/admin_main")
    public String adminMainPage(Model model) {
        // 모든 콘텐츠 정보 조회
        List<ContentsEntity> contentsList = contentsRepository.findAll();

        // 모델에 모든 콘텐츠 정보 추가
        model.addAttribute("contentsList", contentsList);

        return "admin/admin_main";  // 이 페이지에서 콘텐츠 리스트를 출력하는 뷰
    }
}
