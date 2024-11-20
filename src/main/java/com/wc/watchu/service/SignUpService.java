package com.wc.watchu.service;

import com.wc.watchu.dto.SignUpDTO;
import com.wc.watchu.entity.SignUpEntity;
import com.wc.watchu.repository.SignUpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service //스프링이 관리해주는 객체 == 스프링 빈
@RequiredArgsConstructor //controller와 같이. final 멤버변수 생성자 만드는 역할
public class SignUpService {
    private final SignUpRepository signUpRepository;

    public void save(SignUpDTO signUpDTO) {
        SignUpEntity signUpEntity = SignUpEntity.toSignUpEntity(signUpDTO);
        signUpRepository.save(signUpEntity);
    }
}