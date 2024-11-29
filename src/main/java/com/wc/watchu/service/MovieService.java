package com.wc.watchu.service;

import com.wc.watchu.dto.MovieDTO;
import com.wc.watchu.entity.MovieEntity;
import com.wc.watchu.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service //스프링이 관리해주는 객체 == 스프링 빈
@RequiredArgsConstructor //controller와 같이. final 멤버변수 생성자 만드는 역할
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<MovieDTO> getMoviesByContent(int contentsId) {
        // 콘텐츠 ID로 영화 목록을 조회하고, 바로 MovieDTO로 변환하여 반환
        return movieRepository.findByContent_ContentsId(contentsId).stream()
                .map(MovieDTO::toMovieDTO)  // MovieDTO 변환
                .collect(Collectors.toList());
    }
}
