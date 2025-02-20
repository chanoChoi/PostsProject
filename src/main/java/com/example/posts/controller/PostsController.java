package com.example.posts.controller;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.posts.dto.DeleteDto;
import com.example.posts.dto.PostsPwDto;
import com.example.posts.dto.PostsRequestDto;
import com.example.posts.entity.Posts;
import com.example.posts.service.PostsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PostsController {

	private final PostsService postsService;

	@PostMapping("/api/posts")
	public Posts createPosts(@RequestBody PostsRequestDto requestDto) {
		return postsService.createPosts(requestDto);
	}

	@GetMapping("/api/allposts")
	public List<Posts> getPosts() {
		return postsService.getPosts();
	}

	@GetMapping("/api/posts/{id}")
	public PostsPwDto getPosts(@PathVariable Long id) {
		return postsService.getPost(id);
	}

	@PutMapping("/api/posts/{id}")
	public PostsPwDto updatePosts(@PathVariable Long id,
		@RequestBody PostsRequestDto postsRequestDto) {
		return postsService.updatePosts(id, postsRequestDto);
	}

	@Transactional
	@DeleteMapping("/api/posts/{id}")
	public DeleteDto deletePosts(@PathVariable Long id,
		@RequestBody PostsRequestDto postsRequestDto) {
		return postsService.deletePosts(id, postsRequestDto);
	}

}
