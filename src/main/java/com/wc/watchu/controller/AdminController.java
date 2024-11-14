package com.wc.watchu.controller;

import com.wc.watchu.repository.AdminRepository;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {
    private final AdminRepository adminRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @GetMapping("/login")
    public String login() {
        return "admin/login";
    }

    @PostMapping("/signup")
    public String signup(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        adminRepository.save(user);
        return "redirect:/login";
    }
}
