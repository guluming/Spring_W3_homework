package com.sparta.spring_w3_homework.controller;


import com.sparta.spring_w3_homework.domain.Noticeboard;
import com.sparta.spring_w3_homework.domain.NoticeboardRepository;
import com.sparta.spring_w3_homework.domain.NoticeboardRequestDto;
import com.sparta.spring_w3_homework.service.NoticeboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class NoticeboardController {

    private final NoticeboardRepository noticeboardRepository;

    private final NoticeboardService noticeboardService;

    @PostMapping("/api/noticeboards/")
    public Noticeboard creatNoticeboard(@RequestBody NoticeboardRequestDto requestDto){
        Noticeboard noticeboard = new Noticeboard(requestDto);
        return noticeboardRepository.save(noticeboard);
    }

    @GetMapping("/api/noticeboards/")
    public List<Noticeboard> readNoticeboard(){
        return noticeboardRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/noticeboards/{id}")
    public Long updateNoticeboard(@PathVariable Long id, @RequestBody NoticeboardRequestDto requestDto){
        noticeboardService.update(id, requestDto);
        return id;
    }

    @DeleteMapping("/api/noticeboards/{id}")
    public Long deleteNoticeboard(@PathVariable Long id){
        noticeboardRepository.deleteById(id);
        return id;
    }
}
