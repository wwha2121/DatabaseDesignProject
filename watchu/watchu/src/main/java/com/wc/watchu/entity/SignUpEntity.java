package com.wc.watchu.entity;

import jakarta.persistence.*;
import com.wc.watchu.dto.SignUpDTO;
import lombok.*;

import java.sql.Date;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "member")
public class SignUpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;

    @Column(nullable = false, length = 100)
    private String memberName;

    @Column(nullable = false, length = 100)
    private Date birthday;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'MALE'")
    private SexEnum sex;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Builder
    public static SignUpEntity toSignUpEntity(SignUpDTO signUpDTO) {
        SignUpEntity signUpEntity = new SignUpEntity();

        signUpEntity.setMemberId(signUpDTO.getMemberId());
        signUpEntity.setMemberName(signUpDTO.getMemberName());
        signUpEntity.setBirthday(signUpDTO.getBirthday());
        signUpEntity.setSex(signUpDTO.getSex());
        signUpEntity.setEmail(signUpDTO.getEmail());
        signUpEntity.setPassword(signUpDTO.getPassword());

        return signUpEntity;
    }
}