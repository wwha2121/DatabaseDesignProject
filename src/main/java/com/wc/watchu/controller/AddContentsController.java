package com.wc.watchu.controller;

import com.wc.watchu.dto.ContentsDTO;
import com.wc.watchu.service.AddContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AddContentsController {
    private final AddContentsService addContentsService;

    @GetMapping("/add_contents")
    public String acPage() {
        return "sub/contents/add_contents";
    }

    @PostMapping("/add_contents")
    public String save(@ModelAttribute ContentsDTO addContentsDTO) {

        System.out.println("AddContentsController");
        System.out.println("contentsDTO = " + addContentsDTO);
        addContentsService.save(addContentsDTO);

        return "index";
    }
}