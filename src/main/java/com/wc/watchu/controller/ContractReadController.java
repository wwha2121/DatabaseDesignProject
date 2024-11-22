package com.wc.watchu.controller;

import com.wc.watchu.entity.ContractEntity;
import com.wc.watchu.repository.ContractRepository;
import com.wc.watchu.service.ContractRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ContractReadController {

    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private ContractRegistrationService contractRegistrationService;

    // 모든 계약 리스트 페이지
    @GetMapping("/contract_read")
    public String contractReadPage(Model model) {
        // 모든 계약 정보 조회
        List<ContractEntity> contractList = contractRepository.findAllWithContents();

        // 모델에 모든 계약 정보 추가
        model.addAttribute("contractList", contractList);

        return "admin/contract_read";  // 계약 리스트를 출력하는 뷰
    }

    @DeleteMapping("/contract_read/delete/{contractId}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long contractId) {
        boolean deleted = contractRegistrationService.deleteContractById(contractId);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
