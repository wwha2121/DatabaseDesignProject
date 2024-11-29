package com.wc.watchu.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private int id; // 유저 아이디
    private String email; // 사용자 이메일
    private String password; // 비밀번호
    private String name;
}