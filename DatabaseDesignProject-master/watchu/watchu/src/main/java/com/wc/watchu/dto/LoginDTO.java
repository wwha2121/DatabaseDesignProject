package com.wc.watchu.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String email; // 사용자 아이디
    private String password; // 비밀번호
}