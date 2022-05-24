package com.sparta.spring_w3_homework.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Entity
public class Noticeboard extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String username;

    private String title;

    private String contents;

    private int password;

    private char deleteYn;

    private LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime modifiedDate = LocalDateTime.now();

    @Builder
    public Noticeboard(String username, String title, String contents, int password, char deleteYn) {
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.password = password;
        this.deleteYn = deleteYn;
    }

//    public Noticeboard(NoticeboardRequestDto requestDto) {
//        this.username = requestDto.getUsername();
//        this.title = requestDto.getTitle();
//        this.contents = requestDto.getContents();
//        this.password = requestDto.getPassword();
//    }

//    public void update(NoticeboardRequestDto requestDto){
//        this.username = requestDto.getUsername();
//        this.title = requestDto.getTitle();
//        this.contents = requestDto.getContents();
//    }

    public void update(String username, String title, String contents){
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.modifiedDate = LocalDateTime.now();
    }

    public void delete(){
        this.deleteYn = 'Y';
    }
}
