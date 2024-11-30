package com.wc.watchu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class AdminLoginController {

    // 로그인 페이지 표시
    @GetMapping("/admin")
    public String index() {
        return "admin/admin_signup";
    }

    // 로그인 요청 처리
    @PostMapping("/admin")
    public String loginAdmin(String username, String password, Model model) {
        if ("admin".equals(username) && "1234".equals(password)) {
            // 로그인 성공
            return "redirect:/admin_main"; // 대시보드로 리디렉션 (로그인 성공 후 페이지)
        } else {
            // 로그인 실패
            model.addAttribute("error", "아이디 또는 비밀번호가 틀렸습니다.");
            return "/admin/admin_signup"; // 로그인 실패시 로그인 페이지로 다시 돌아감
        }
    }
}