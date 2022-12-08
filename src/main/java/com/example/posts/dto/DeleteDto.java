package com.example.posts.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteDto {
    private String msg;

    public void SetMsg(String msg) {
        this.msg = msg;
    }
}