package com.wc.watchu.controller;

import com.wc.watchu.dto.MovieDTO;
import com.wc.watchu.entity.ContentsEntity;
import com.wc.watchu.repository.ContentsRepository;
import com.wc.watchu.service.AddMovieService;
import com.wc.watchu.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MovieController {
    private final AddMovieService addMovieService;
    @Autowired
    private ContentsRepository contentsRepository;
    @Autowired
    private MovieService movieService;

    @GetMapping("/add_movie")
    public String amPage(Model model) {
        List<ContentsEntity> movieContents = contentsRepository.findByContentsCategoryOrderByContentsIdDesc("MOVIE");

        // 모델에 콘텐츠 리스트 전달
        model.addAttribute("movieContents", movieContents);
        return "sub/contents/add_movie";
    }

    @GetMapping("/movie/{contentsId}")
    public String getMoviesByContent(@PathVariable("contentsId") Long contentsId, Model model) {
        List<MovieDTO> movies = movieService.getMoviesByContent(contentsId);
        model.addAttribute("movies", movies);
        return "sub/contents/movie"; // 영화 목록을 표시할 템플릿 이름
    }

    @PostMapping("/add_movie")
    public String addMovie(@ModelAttribute MovieDTO movieDTO, RedirectAttributes redirectAttributes) {
        try {
            addMovieService.save(movieDTO);
            return "redirect:/main";  // 영화 목록으로 리다이렉트
        } catch (RuntimeException e) {
            // 예외가 발생하면 실패 메시지를 RedirectAttributes에 추가
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
            return "redirect:/main";  // 메인 페이지로 리다이렉트
        }
    }
}