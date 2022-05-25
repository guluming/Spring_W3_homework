package com.sparta.spring_w3_homework.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class NoticeboardRequestDto extends Timestamped {
    private String username;
    private String title;
    private String contents;
    private String password;
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public Noticeboard toEntity(){
        return Noticeboard.builder()
                .username(username)
                .title(title)
                .contents(contents)
                .password(password)
                .createAt(createdAt)
                .modifiedAt(modifiedAt)
                .build();
    }
}
