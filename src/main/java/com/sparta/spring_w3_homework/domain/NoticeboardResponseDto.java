package com.sparta.spring_w3_homework.domain;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class NoticeboardResponseDto extends Timestamped {

    private Long id;
    private String username;
    private String title;
    private String contents;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

//    private LocalDateTime createdDate;
//    private LocalDateTime modifiedDate;

    public NoticeboardResponseDto(Noticeboard entity){
        this.id = entity.getId();
        this.username = entity.getUsername();
        this.title = entity.getTitle();
        this.contents = entity.getContents();
        this.createdAt = entity.getCreatedAt();
        this.modifiedAt = entity.getModifiedAt();

//        this.createdDate = entity.getCreatedDate();
//        this.modifiedDate = entity.getModifiedDate();
    }
}
