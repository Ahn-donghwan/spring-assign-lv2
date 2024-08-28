package com.sparta.springlv2assign.dto.todo.response;

import lombok.Getter;

@Getter
public class TodoUpdateResponseDto {

    private final String title;
    private final String contents;

    public TodoUpdateResponseDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
