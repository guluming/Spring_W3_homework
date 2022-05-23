package com.sparta.spring_w3_homework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class NoticeboardPageController {

    @GetMapping("/view")
    public String openBoardview() {
        return "board/view";
    }
}
