package com.example.posts.dto;

import com.example.posts.entity.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostsPwDto {
    private String title;
    private String writer;
    private String contents;
    private String pw;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public PostsPwDto (Posts posts){
        this.title = posts.getTitle();
        this.writer = posts.getWriter();
        this.contents = posts.getContents();
        this.pw = posts.getPw();
        this.createAt = posts.getCreateAt();
        this.modifiedAt = posts.getModifiedAt();
    }
}



