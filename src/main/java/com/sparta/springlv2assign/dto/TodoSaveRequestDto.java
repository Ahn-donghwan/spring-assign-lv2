package com.sparta.springlv2assign.dto;

import lombok.Getter;

@Getter
public class TodoSaveRequestDto {

    private Long id;
    private String title;
    private String contents;

}
