package com.sparta.spring_w3_homework.service;

import com.sparta.spring_w3_homework.domain.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NoticeboardService extends Timestamped {

    private final NoticeboardRepository noticeboardRepository;

    //게시글 저장
    @Transactional
    public Long save(NoticeboardRequestDto params){
        Noticeboard entity = noticeboardRepository.save(params.toEntity());
        return entity.getId();
    }

    //게시글 전체 조회
    public List<NoticeboardResponseDto> findAll(){
        Sort sort = Sort.by(Direction.DESC, "modifiedAt");
        List<Noticeboard> list = noticeboardRepository.findAll(sort);
        return list.stream().map(NoticeboardResponseDto::new).collect(Collectors.toList());
    }

    //게시글 상세 정보
    @Transactional
    public NoticeboardResponseDto findById(Long id){
        Noticeboard entity = noticeboardRepository.findById(id).orElseThrow(() -> new NullPointerException("존재하지 않는 게시글 입니다."));
        return new NoticeboardResponseDto(entity);
    }

    //게시글 수정
    @Transactional
    public Long update(Long id, NoticeboardRequestDto params){
        Noticeboard entity = noticeboardRepository.findById(id).orElseThrow(() -> new NullPointerException("존재하지 않는 게시글 입니다."));
        entity.update(params.getUsername(), params.getTitle(), params.getContents());
        return id;
    }

    //게시글 삭제
    @Transactional
    public Long delete(Long id){
        noticeboardRepository.deleteById(id);
        return id;
    }

    //비밀번호 확인
    public boolean checkPw(Long id, NoticeboardRequestDto params){
        Noticeboard entity = noticeboardRepository.findById(id).orElseThrow(() -> new NullPointerException("존재하지 않는 게시글 입니다."));
        if(params.getPassword().equals(entity.getPassword())){
            return true;
        } else {
            return false;
        }
    }
}
