package com.sparta.springlv2assign.controller;

import com.sparta.springlv2assign.dto.todo.request.TodoSaveRequestDto;
import com.sparta.springlv2assign.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.springlv2assign.dto.todo.response.TodoSaveResponseDto;
import com.sparta.springlv2assign.dto.todo.response.TodoSimpleResponseDto;
import com.sparta.springlv2assign.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.springlv2assign.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoSaveResponseDto> saveTodo(@RequestBody TodoSaveRequestDto todoSaveRequestDto){
        return ResponseEntity.ok(todoService.saveTodo(todoSaveRequestDto));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<TodoSimpleResponseDto>> getTodos(){
        return ResponseEntity.ok(todoService.getTodos());
    }

    @PutMapping("/todos/{todoId}")
    public ResponseEntity<TodoUpdateResponseDto> updateTodo(@PathVariable Long todoId, @RequestBody TodoUpdateRequestDto todoUpdateRequestDto){
        return ResponseEntity.ok(todoService.updateTodo(todoId, todoUpdateRequestDto));
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodo(@PathVariable Long todoId){
        todoService.deleteTodo(todoId);
    }
}
