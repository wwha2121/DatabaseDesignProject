package com.wc.watchu.controller;

import com.wc.watchu.dto.EpisodeDTO;
import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.repository.ContentsRepository;
import com.wc.watchu.service.AddEpisodeService;
import com.wc.watchu.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class EpisodeController {
    private final AddEpisodeService addEpisodeService;  // 에피소드 추가 서비스

    @Autowired
    private ContentsRepository contentsRepository;  // 콘텐츠 저장소

    @Autowired
    private EpisodeService episodeService;  // 에피소드 서비스

    // 에피소드 추가 페이지
    @GetMapping("/add_episode")
    public String addEpisodePage(Model model) {
        List<ContentsEntity> episodeContents = contentsRepository.findByContentsCategoryOrderByContentsIdDesc("SERIES");

        // 모델에 에피소드 콘텐츠 리스트 전달
        model.addAttribute("episodeContents", episodeContents);
        return "sub/contents/add_episode";  // 에피소드 추가 템플릿
    }

    // 특정 콘텐츠에 대한 에피소드 목록 가져오기
    @GetMapping("/episode/{contentsId}")
    public String getEpisodesByContent(@PathVariable("contentsId") Long contentsId, Model model) {
        List<EpisodeDTO> episodeList = episodeService.getEpisodesByContent(contentsId);
        model.addAttribute("episodes", episodeList);  // 에피소드 목록을 모델에 추가
        return "sub/contents/episode";  // 에피소드 목록을 표시할 템플릿
    }

    // 에피소드 추가
    @PostMapping("/add_episode")
    public String addEpisode(@ModelAttribute EpisodeDTO episodeDTO, RedirectAttributes redirectAttributes) {
        try {
            addEpisodeService.save(episodeDTO);  // 에피소드 저장 서비스
            return "redirect:/main";  // 메인 페이지로 리다이렉트
        } catch (RuntimeException e) {
            // 예외 발생 시 실패 메시지 전달
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/main";  // 메인 페이지로 리다이렉트
        }
    }
}
