package com.sparta.springlv2assign.dto.comment.response;

public class CommentSaveResponseDto {

    private final Long id;
    private final String contents;

    public CommentSaveResponseDto(Long id, String contents) {
        this.id = id;
        this.contents = contents;
    }
}
