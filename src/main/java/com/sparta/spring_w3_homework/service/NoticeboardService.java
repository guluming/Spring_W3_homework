package com.sparta.spring_w3_homework.service;

import com.sparta.spring_w3_homework.domain.Noticeboard;
import com.sparta.spring_w3_homework.domain.NoticeboardRepository;
import com.sparta.spring_w3_homework.domain.NoticeboardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class NoticeboardService {

    private final NoticeboardRepository noticeboardRepository;

    //게시글 수정
    @Transactional
    public Long update(Long id, NoticeboardRequestDto requestDto){
        Noticeboard noticeboard = noticeboardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("존재하지 않는 사용자 입니다.")
        );
        noticeboard.update(requestDto);
        return noticeboard.getId();
    }

    //게시글 상세 정보
    @Transactional
    public NoticeboardRequestDto findById(Long id){
        Noticeboard noticeboard = noticeboardRepository.findById(id).orElseThrow(
                () -> new NullPointerException("존재하지 않는 게시글 입니다")
        );
        return new NoticeboardRequestDto();
    }
}
