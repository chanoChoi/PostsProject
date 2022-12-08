package com.example.bulletin.service;

import com.example.bulletin.dto.PostsRequestDto;
import com.example.bulletin.entity.Posts;
import com.example.bulletin.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Posts createPosts(PostsRequestDto requestDto){
        Posts posts = new Posts(requestDto);
        postsRepository.save(posts);
        return posts;
    }

    @Transactional(readOnly = true)
    public List<Posts> getPosts() {
        return postsRepository.findAllByOrderByModifiedAtDesc();
    }






}
