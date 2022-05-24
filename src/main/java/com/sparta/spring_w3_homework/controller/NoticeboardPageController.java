package com.sparta.spring_w3_homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class NoticeboardPageController {

    //상세 페이지
    @GetMapping("/view/{id}")
    public String openNoticeview(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "board/view";
    }

    //수정 페이지
    @GetMapping("/edit/{id}")
    public String openNoticeedit(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "board/edit";
    }
}
