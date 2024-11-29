package com.wc.watchu.controller;

import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.entity.RelatedVideoEntity;
import com.wc.watchu.repository.ContentsRepository;
import com.wc.watchu.repository.RelatedVideoRepository;
import com.wc.watchu.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ContentsController {

    @Autowired
    private ContentsRepository contentsRepository;

    @Autowired
    private RelatedVideoRepository relatedVideoRepository;



    @GetMapping("/contents/{id}")
    public String contentsPage(@PathVariable("id") int contentsId, Model model) {
        // 콘텐츠 ID로 콘텐츠 정보를 조회


        ContentsEntity content = contentsRepository.findByContentsId(contentsId);
        List<RelatedVideoEntity> relatedVideos = relatedVideoRepository.findByContentsId(contentsId);

        // 콘텐츠가 존재하지 않으면 예외 처리
        if (content == null) {
            throw new RuntimeException("해당 콘텐츠를 찾을 수 없습니다.");
        }

        // 모델에 콘텐츠 정보 추가
        model.addAttribute("content", content);
        model.addAttribute("relatedVideos", relatedVideos);

        return "sub/contents/contents";
    }



}