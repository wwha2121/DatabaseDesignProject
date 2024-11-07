package com.wc.watchu.service;

import com.wc.watchu.dto.LoginDTO;
import com.wc.watchu.entity.SignUpEntity;
import com.wc.watchu.repository.SignUpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final SignUpRepository signUpRepository;

    @Autowired
    public LoginService(SignUpRepository signUpRepository) {
        this.signUpRepository = signUpRepository;
    }

    public boolean authenticate(LoginDTO loginDTO) {
        // 이메일로 회원 정보 조회
        SignUpEntity member = signUpRepository.findByEmail(loginDTO.getEmail());

        if (member != null) {
            // 비밀번호 비교
            return loginDTO.getPassword().equals(member.getPassword());
        }

        return false;  // 회원이 없으면 로그인 실패
    }

}