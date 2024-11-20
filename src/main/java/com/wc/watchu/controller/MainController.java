package com.wc.watchu.controller;

import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.entity.MovieEntity;
import com.wc.watchu.repository.ContentsRepository;
import com.wc.watchu.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ContentsRepository contentsRepository;

    @Autowired
    private MovieRepository movieRepository;


    @GetMapping("/main")
    public String mainPage(Model model) {
        // "MOVIE" 카테고리의 콘텐츠를 가져오기
        List<ContentsEntity> movieContents = contentsRepository.findByContentsCategoryOrderByContentsIdDesc("MOVIE");

        // "SERIES" 카테고리의 콘텐츠를 가져오기
        List<ContentsEntity> seriesContents = contentsRepository.findByContentsCategoryOrderByContentsIdDesc("SERIES");

        // 조회수 Top 5 영화 콘텐츠 가져오기
        List<MovieEntity> top5Movies = movieRepository.findTop5ByViewsDesc();

        // 모델에 카테고리별 콘텐츠 추가
        model.addAttribute("movieContents", movieContents);
        model.addAttribute("seriesContents", seriesContents);
        model.addAttribute("top5Movies", top5Movies);

        return "main/main"; // main.html을 반환
    }
}