package com.sparta.spring_w3_homework.domain;

import lombok.Getter;

@Getter
public class NoticeboardRequestDto {
    private String username;
    private String title;
    private String contents;
    private int password;
}
