package com.example.posts.entity;

import com.example.posts.dto.PostsRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor   // 찾기
public class Posts extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // 기본키
    private Long id;

    @Column (nullable = false)
    private String title;

    @Column (nullable = false)
    private String writer;

    @Column (nullable = false)
    private String contents;

    @Column (nullable = false)
    private String pw;


    public Posts(PostsRequestDto requestDto) {               // request dto뭐길래
        this.writer = requestDto.getWriter();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.pw = requestDto.getPw();
    }

    public void update(PostsRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

}
