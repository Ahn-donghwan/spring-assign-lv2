package com.sparta.springlv2assign.dto;

import lombok.Getter;

@Getter
public class TodoUpdateRequestDto {

    private final Long id;
    private final String title;
    private final String contents;

    public TodoUpdateRequestDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}
