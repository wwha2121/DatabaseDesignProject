package com.wc.watchu.service;

import com.wc.watchu.dto.ContractDTO;
import com.wc.watchu.entity.ContractEntity;
import com.wc.watchu.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // Spring 관리 객체
@RequiredArgsConstructor // final 멤버 변수를 위한 생성자 자동 생성
public class ContractRegistrationService {

    private final ContractRepository contractRepository; // Contract 엔티티 저장을 위한 Repository

    // 계약 저장 메소드
    public void save(ContractDTO contractDTO) {
        // ContractDTO를 ContractEntity로 변환
        ContractEntity contractEntity = ContractEntity.toContractEntity(contractDTO);

        // ContractEntity를 데이터베이스에 저장
        contractRepository.save(contractEntity);
    }
}
