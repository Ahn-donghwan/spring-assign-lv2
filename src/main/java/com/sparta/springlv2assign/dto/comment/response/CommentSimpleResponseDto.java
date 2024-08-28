package com.sparta.springlv2assign.dto.comment.response;

import lombok.Getter;

@Getter
public class CommentSimpleResponseDto {

    private final Long id;
    private final String contents;

    public CommentSimpleResponseDto(Long id, String contents) {
        this.id = id;
        this.contents = contents;
    }
}
