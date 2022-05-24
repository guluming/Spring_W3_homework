package com.sparta.spring_w3_homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class NoticeboardPageController {

    @GetMapping("/view/{id}")
    public String openNoticeview(@PathVariable Long id, Model model) {
        model.addAttribute("id", id);
        return "board/view";
    }

//    @GetMapping("/edit")
//    public String openNoticeedit() {
//        return "board/edit";
//    }
}
