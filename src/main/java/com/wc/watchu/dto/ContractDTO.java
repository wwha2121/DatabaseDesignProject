package com.wc.watchu.dto;

import lombok.Getter;
import lombok.Setter;
import java.sql.Date;

@Getter
@Setter
public class ContractDTO {

    private Long contractId; // 계약 ID
    private Date contractStart; // 계약 시작일
    private Date contractEnd; // 계약 종료일
    private int contractPrice; // 계약 가격
    private Long contractDate; // 계약 날짜
    private Long contentsId; // 콘텐츠 ID
    private Long adminId; // 관리자 ID
}
