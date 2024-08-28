package com.sparta.springlv2assign.controller;

import com.sparta.springlv2assign.dto.comment.request.CommentSaveRequestDto;
import com.sparta.springlv2assign.dto.comment.response.CommentSaveResponseDto;
import com.sparta.springlv2assign.dto.comment.response.CommentSimpleResponseDto;
import com.sparta.springlv2assign.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("todos/{todoId}/comments")
    public CommentSaveResponseDto saveComment(@PathVariable Long todoId, @RequestBody CommentSaveRequestDto commentSaveRequestDto) {
        return commentService.saveComment(todoId, commentSaveRequestDto);
    }

    @GetMapping("/todos/comments")
    public List<CommentSimpleResponseDto> getComments() {
        return commentService.getComments();
    }
}
