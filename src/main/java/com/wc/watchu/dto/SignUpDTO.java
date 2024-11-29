package com.wc.watchu.dto;

import com.wc.watchu.entity.SexEnum;
import com.wc.watchu.entity.SignUpEntity;
import lombok.*;

import java.sql.Date;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class SignUpDTO {
    private int memberId;
    private String memberName; // 회원 이름
    private Date birthday; // 생일
    private SexEnum sex; // 성별
    private String email; // 회원 이메일
    private String password; // 회원 비밀번호

    // SignUpEntity를 SignUpDTO로 변환하는 정적 메서드
    public static SignUpDTO toSignUpDTO(SignUpEntity signUpEntity) {

        SignUpDTO signUpDTO = new SignUpDTO();
        signUpDTO.setMemberId(signUpEntity.getMemberId());
        signUpDTO.setMemberName(signUpEntity.getMemberName());
        signUpDTO.setBirthday(signUpEntity.getBirthday());
        signUpDTO.setSex(signUpEntity.getSex());
        signUpDTO.setEmail(signUpEntity.getEmail());
        signUpDTO.setPassword(signUpEntity.getPassword());

        return signUpDTO;
    }
}