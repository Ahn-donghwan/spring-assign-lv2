package com.sparta.springlv2assign.service;

import com.sparta.springlv2assign.dto.comment.request.CommentSaveRequestDto;
import com.sparta.springlv2assign.dto.comment.response.CommentSaveResponseDto;
import com.sparta.springlv2assign.dto.comment.response.CommentSimpleResponseDto;
import com.sparta.springlv2assign.entity.Comment;
import com.sparta.springlv2assign.entity.Todo;
import com.sparta.springlv2assign.repository.CommentRepository;
import com.sparta.springlv2assign.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional // 저는 왜 (readOnly = true) 를 붙이면 오류가 뜨는 걸까요...
public class CommentService {

    private final TodoRepository todoRepository;
    private final CommentRepository commentRepository;

    public CommentSaveResponseDto saveComment(Long todoId, CommentSaveRequestDto commentSaveRequestDto) {

        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("해당 ID 를 찾을 수 없습니다."));

        Comment newComment = new Comment(commentSaveRequestDto.getContents(), todo);
        Comment savedComment = commentRepository.save(newComment);

        return new CommentSaveResponseDto(savedComment.getId(), savedComment.getContents());
    }

    public List<CommentSimpleResponseDto> getComments() {
        List<Comment>  commentList = commentRepository.findAll();

        List<CommentSimpleResponseDto> dtoList = new ArrayList<>();
        for (Comment comment : commentList) {
            dtoList.add(new CommentSimpleResponseDto(comment.getId(), comment.getContents()));
        }
        return dtoList;
    }

}
