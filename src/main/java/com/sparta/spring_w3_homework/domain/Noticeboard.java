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

    private String password;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt = LocalDateTime.now();

//    private LocalDateTime createdDate;
//
//    private LocalDateTime modifiedDate = LocalDateTime.now();

    @Builder
    public Noticeboard(String username, String title, String contents, String password, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.password = password;
        this.createdAt = createAt;
        this.modifiedAt = modifiedAt;
    }

    public void update(String username, String title, String contents){
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.modifiedAt = LocalDateTime.now();
//        this.modifiedDate = LocalDateTime.now();
    }
}
