package com.sparta.springlv2assign.service;

import com.sparta.springlv2assign.dto.todo.request.TodoSaveRequestDto;
import com.sparta.springlv2assign.dto.todo.request.TodoUpdateRequestDto;
import com.sparta.springlv2assign.dto.todo.response.TodoSaveResponseDto;
import com.sparta.springlv2assign.dto.todo.response.TodoSimpleResponseDto;
import com.sparta.springlv2assign.dto.todo.response.TodoUpdateResponseDto;
import com.sparta.springlv2assign.entity.Todo;
import com.sparta.springlv2assign.repository.TodoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoService {

    private final TodoRepository todoRepository;

    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto todoSaveRequestDto) {

        Todo newTodo = new Todo(
                todoSaveRequestDto.getId(),
                todoSaveRequestDto.getTitle(),
                todoSaveRequestDto.getContents()
        );
        Todo savedTodo = todoRepository.save(newTodo);

        return new TodoSaveResponseDto(savedTodo.getId(), savedTodo.getTitle(), savedTodo.getContents());
    }

    public List<TodoSimpleResponseDto> getTodos() {
        List<Todo> todoList = todoRepository.findAll();

        List<TodoSimpleResponseDto> dtoList =  new ArrayList<>();
        for (Todo todo : todoList) {
            TodoSimpleResponseDto dto = new TodoSimpleResponseDto(todo.getId(), todo.getTitle());
            dtoList.add(dto);
        }
        return dtoList;
    }

    // 영속성 Context
    @Transactional
    public TodoUpdateResponseDto updateTodo(Long todoId, TodoUpdateRequestDto todoUpdateRequestDto) {
        Todo todo = todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("해당 내용을 찾을 수 없습니다."));
        todo.update(todoUpdateRequestDto.getTitle(), todoUpdateRequestDto.getContents());

        return new TodoUpdateResponseDto(todo.getTitle(), todo.getContents());
    }

    public void deleteTodo(Long todoId) {
        if (!todoRepository.existsById(todoId)) {
            throw new NullPointerException("해당 ID 를 찾을 수 없습니다.");
        }

        todoRepository.deleteById(todoId);
    }
}
