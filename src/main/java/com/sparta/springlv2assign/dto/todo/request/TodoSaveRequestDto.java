package com.sparta.springlv2assign.dto.todo.request;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {

    private Long id;
    private String title;
    private String contents;

}
