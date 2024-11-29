package com.wc.watchu.controller;

import com.wc.watchu.dto.ContentsDTO;
import com.wc.watchu.dto.ContentsRequestDTO;
import com.wc.watchu.dto.RelatedVideoDTO;
import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.entity.RelatedVideoEntity;
import com.wc.watchu.repository.ContentsRepository;
import com.wc.watchu.repository.RelatedVideoRepository;
import com.wc.watchu.service.AddContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AddContentsController {
    private final AddContentsService addContentsService; // 주입 완료
    private final ContentsRepository contentsRepository; // 주입 가능하도록 final 추가
    private final RelatedVideoRepository relatedVideoRepository; // 주입 가능하도록 final 추가

    @GetMapping("/add_contents")
    public String acPage() {
        return "sub/contents/add_contents";
    }

    @PostMapping("/add_contents")
    public String addContents(@RequestBody ContentsRequestDTO requestDTO) {
        // JSON에서 ContentsDTO와 RelatedVideoDTO 추출
        ContentsDTO contentsDTO = requestDTO.getContentsDTO();
        RelatedVideoDTO relatedVideoDTO = requestDTO.getRelatedVideoDTO();

        // 디버깅용 출력
        System.out.println("Received ContentsDTO: " + contentsDTO);
        System.out.println("Received RelatedVideoDTO: " + relatedVideoDTO);

        // Null 체크 (예외 방지)
        if (contentsDTO == null) {
            throw new IllegalArgumentException("ContentsDTO is null!");
        }

        // Contents 저장
        ContentsEntity contentsEntity = ContentsEntity.toContentsEntity(contentsDTO);
        contentsRepository.save(contentsEntity);
        RelatedVideoEntity relatedVideoEntity = RelatedVideoEntity.toRelatedVideoEntity(relatedVideoDTO, contentsEntity);
        relatedVideoRepository.save(relatedVideoEntity);

        // 관련 비디오 저장 (optional)
//        if (relatedVideoDTO != null && relatedVideoDTO.getVideoPath() != null) {
//            relatedVideoDTO.setContentsId(contentsEntity.getContentsId());
//
//        }

        return "index";
    }


}
