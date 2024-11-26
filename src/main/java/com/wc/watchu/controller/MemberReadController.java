package com.wc.watchu.controller;

import com.wc.watchu.dto.SignUpDTO;
import com.wc.watchu.entity.SignUpEntity;
import com.wc.watchu.repository.SignUpRepository;
import com.wc.watchu.service.MemberService; // Assuming you have a service for members
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MemberReadController {

    @Autowired
    private SignUpRepository signUpRepository;

    @Autowired
    private MemberService memberService; // Service class to handle member-related logic

    // 모든 회원 리스트 페이지
    @GetMapping("/member_read")
    public String memberReadPage(Model model) {
        // 모든 회원 정보 조회 (SignUpEntity 객체들을 가져옴)
        List<SignUpEntity> signUpEntities = signUpRepository.findAll();

        // SignUpEntity를 SignUpDTO로 변환하여 모델에 추가
        List<SignUpDTO> signUpDTOList = signUpEntities.stream()
                .map(SignUpDTO::toSignUpDTO)  // Entity -> DTO 변환
                .collect(Collectors.toList());

        // 모델에 회원 정보 추가
        model.addAttribute("signUpList", signUpDTOList);

        return "admin/member_read";  // 회원 리스트를 출력하는 뷰
    }

    // 회원 삭제 기능 (옵션, 필요시 구현)
    @DeleteMapping("/member_read/delete/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        boolean deleted = memberService.deleteMemberById(memberId);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
