package com.sparta.spring_w3_homework.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeboardResponseDto {

    private Long id;
    private String username;
    private String title;
    private String contents;
    private int password;
    private char deleteYn;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public NoticeboardResponseDto(Noticeboard entity){
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.password = entity.getPassword();
        this.deleteYn = entity.getDeleteYn();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
