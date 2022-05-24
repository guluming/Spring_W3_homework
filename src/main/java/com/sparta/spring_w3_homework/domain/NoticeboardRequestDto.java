package com.sparta.spring_w3_homework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NoticeboardRequestDto {
    private String username;
    private String title;
    private String contents;
    private String password;

    public Noticeboard toEntity(){
        return Noticeboard.builder()
                .username(username)
                .title(title)
                .contents(contents)
                .password(password)
                .build();
    }
}
