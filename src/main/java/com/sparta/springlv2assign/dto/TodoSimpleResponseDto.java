package com.sparta.springlv2assign.dto;

import lombok.Getter;

@Getter
public class TodoSimpleResponseDto {

    private final Long id;
    private final String title;

    public TodoSimpleResponseDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
