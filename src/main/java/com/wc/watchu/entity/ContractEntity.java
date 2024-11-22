package com.wc.watchu.entity;

import com.wc.watchu.dto.ContractDTO;
import jakarta.persistence.*;
import lombok.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "contract")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractId; // 계약 ID

    @Column
    private Date contractStart; // 계약 시작일

    @Column
    private Date contractEnd; // 계약 종료일

    @Column
    private int contractPrice; // 계약 가격

    @Column
    private Long contractDate; // 계약 날짜

    @Column
    private Long contentsId; // 콘텐츠 ID (외래 키 제약조건 없이 단순 ID 참조)

    @Column
    private Long adminId; // 관리자 ID (외래 키 제약조건 없이 단순 ID 참조)

    // ContractDTO를 ContractEntity로 변환하는 메서드
    public static ContractEntity toContractEntity(ContractDTO contractDTO) {
        ContractEntity contractEntity = new ContractEntity();
        contractEntity.setContractStart(contractDTO.getContractStart());
        contractEntity.setContractEnd(contractDTO.getContractEnd());
        contractEntity.setContractPrice(contractDTO.getContractPrice());
        contractEntity.setContractDate(contractDTO.getContractDate());
        contractEntity.setContentsId(contractDTO.getContentsId());
        contractEntity.setAdminId(contractDTO.getAdminId());

        return contractEntity;
    }
}
