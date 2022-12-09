package com.example.posts.service;

import com.example.posts.dto.DeleteDto;
import com.example.posts.dto.PostsPwDto;
import com.example.posts.dto.PostsRequestDto;
import com.example.posts.entity.Posts;
import com.example.posts.repository.PostsRepository;
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

    public  PostsPwDto getPost(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("일치하는 게시글이 없습니다.")
        );
        return  new PostsPwDto(posts);
    }

    @Transactional
    public PostsPwDto updatePosts(Long id, PostsRequestDto postsRequestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(
                () -> new RuntimeException("작성된 글이 없습니다.")
        );
        PostsPwDto postsPwDto = new PostsPwDto(posts);
        if (postsRequestDto.getPw().equals(posts.getPw())){
            posts.update(postsRequestDto);
            return postsPwDto;
        } else{
            return postsPwDto;
        }
    }
    @Transactional
    public DeleteDto deletePosts(Long id, PostsRequestDto postsRequestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("작성된 글이 없습니다.")
        );
        DeleteDto deleteDto = new DeleteDto();
        if (postsRequestDto.getPw().equals(posts.getPw())){
            postsRepository.deleteById(id);
            deleteDto.SetMsg("삭제되었습니다.");
        } else {
            deleteDto.SetMsg("실패하였습니다.");
        }
        return deleteDto;

    }
}
