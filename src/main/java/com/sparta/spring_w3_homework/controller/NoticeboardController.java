package com.sparta.spring_w3_homework.controller;


import com.sparta.spring_w3_homework.domain.Noticeboard;
import com.sparta.spring_w3_homework.domain.NoticeboardRepository;
import com.sparta.spring_w3_homework.domain.NoticeboardRequestDto;
import com.sparta.spring_w3_homework.domain.NoticeboardResponseDto;
import com.sparta.spring_w3_homework.service.NoticeboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class NoticeboardController {

    private final NoticeboardRepository noticeboardRepository;

    private final NoticeboardService noticeboardService;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    //게시글 수정
    @PatchMapping("/noticeboards/{id}")
    public Long update(@PathVariable Long id, @RequestBody NoticeboardRequestDto params){
        return noticeboardService.update(id, params);
    }

    //게시글 상세 조회
    @GetMapping("/noticeboards/{id}")
    public NoticeboardResponseDto findById(@PathVariable Long id){
        return noticeboardService.findById(id);
    }

    //게시글 삭제
    @DeleteMapping("/noticeboards/{id}")
    public Long delete(@PathVariable Long id){
        return noticeboardService.delete(id);
    }
}
