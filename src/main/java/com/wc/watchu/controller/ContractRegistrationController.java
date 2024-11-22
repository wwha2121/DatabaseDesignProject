package com.wc.watchu.controller;

import com.wc.watchu.dto.ContractDTO;
import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.repository.ContentsRepository;
import com.wc.watchu.service.ContractRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ContractRegistrationController {

    private final ContractRegistrationService contractRegistrationService;
    @Autowired
    private ContentsRepository contentsRepository;

    // 계약 등록 페이지로 이동 (모든 콘텐츠를 하나의 리스트로 가져옴)
    @GetMapping("/contract_registration")
    public String registerContractPage(Model model) {
        // 모든 콘텐츠 가져오기 (카테고리 구분 없이)
        List<ContentsEntity> allContents = contentsRepository.findAll();

        // 모델에 모든 콘텐츠 리스트 전달
        model.addAttribute("allContents", allContents);

        return "admin/contract_registration"; // 계약 등록 페이지로 이동
    }

    // 계약 등록 처리
    @PostMapping("/contract_registration")
    public String registerContract(@ModelAttribute ContractDTO contractDTO, RedirectAttributes redirectAttributes) {
        try {
            // 계약 등록 서비스 호출
            contractRegistrationService.save(contractDTO);
            return "redirect:/admin_main";  // 계약 등록 성공 후 메인 페이지로 리다이렉트
        } catch (RuntimeException e) {
            // 예외 발생 시 실패 메시지 전달
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/admin_main";  // 실패 시 메인 페이지로 리다이렉트
        }
    }
}

