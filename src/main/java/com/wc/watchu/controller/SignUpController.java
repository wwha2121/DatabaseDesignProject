package com.wc.watchu.controller;

import com.wc.watchu.dto.SignUpDTO;
import com.wc.watchu.service.SignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SignUpController {
    private final SignUpService signUpService;

    @GetMapping("/sign_up")
    public String signUpPage() {
        return "sub/sign_up/sign_up";
    }

    @PostMapping("/sign_up")
    public String save(@ModelAttribute SignUpDTO signUpDTO) {

        System.out.println("SignController");
        System.out.println("signUpDTO = " + signUpDTO);
        signUpService.save(signUpDTO);

        return "index";
    }
}