package com.sparta.spring_w3_homework.controller;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sparta.spring_w3_homework.domain.Noticeboard;
import com.sparta.spring_w3_homework.domain.NoticeboardRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.sparta.spring_w3_homework.domain.NoticeboardRequestDto;
import com.sparta.spring_w3_homework.domain.NoticeboardResponseDto;
import com.sparta.spring_w3_homework.service.NoticeboardService;

import lombok.RequiredArgsConstructor;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class NoticeboardController {

    private final NoticeboardRepository noticeboardRepository;

    private final NoticeboardService noticeboardService;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //저장
    @PostMapping("/noticeboards")
    public Long save(@RequestBody NoticeboardRequestDto params){
        return noticeboardService.save(params);
    }

    //게시글 전체 조회
    @GetMapping("/noticeboards")
    public List<NoticeboardResponseDto> findAll(){
        return noticeboardService.findAll();
    }

    //게시글 상세 조회
    @GetMapping("/noticeboards/{id}")
    public NoticeboardResponseDto findById(@PathVariable Long id){
        return noticeboardService.findById(id);
    }

    //게시글 수정
    @PatchMapping("/noticeboards/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeboardRequestDto params){
        boolean result = noticeboardService.checkPw(id, params);
        if(result){
            noticeboardService.update(id, params);
        } else {
            System.out.println("비밀번호가 틀렸습니다.");
        }
        return id;
    }

    //게시글 삭제
    @DeleteMapping("/noticeboards/{id}")
    public Long delete(@PathVariable Long id, @RequestBody NoticeboardRequestDto params){
        boolean result = noticeboardService.checkPw(id, params);
        if(result){
            noticeboardService.delete(id);
        } else {
            System.out.println("비밀번호가 틀렸습니다.");
        }
        return id;
    }
}
