package com.wc.watchu.controller;

import com.wc.watchu.dto.LoginDTO;
import com.wc.watchu.service.LoginService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginPage() {
        return "sub/login/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, Model model, HttpSession session) {

        System.out.println("SignController");
        System.out.println("signUpDTO = " + loginDTO);

        // 로그인 처리
        if (loginService.authenticate(loginDTO)) {
            // 로그인 성공 시 세션에 이메일 저장
            session.setAttribute("userEmail", loginDTO.getEmail());
            return "redirect:/main"; // 로그인 후 메인 페이지로 리디렉션
        }else {
            // 로그인 실패 시, 로그인 페이지로 다시 돌아가서 오류 메시지를 보여줌
            model.addAttribute("error", "이메일 또는 비밀번호가 잘못되었습니다.");
            return "sub/login/login";  // 로그인 페이지로 돌아가며, 오류 메시지를 처리할 수 있음
        }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
            // 로그아웃 시 세션에서 이메일 제거
        session.removeAttribute("userEmail");
        return "redirect:/main"; // 로그아웃 후 메인 페이지로
    }
}