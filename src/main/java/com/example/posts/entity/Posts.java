package com.example.posts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.posts.dto.PostsRequestDto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends Timestamped {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) // 기본키
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String writer;

	@Column(nullable = false)
	private String contents;

	@Column(nullable = false)
	private String pw;

	public Posts(PostsRequestDto requestDto) {
		this.writer = requestDto.getWriter();
		this.title = requestDto.getTitle();
		this.contents = requestDto.getContents();
		this.pw = requestDto.getPw();
	}

	public void update(PostsRequestDto requestDto) {
		this.title = requestDto.getTitle();
		this.contents = requestDto.getContents();
	}

}
