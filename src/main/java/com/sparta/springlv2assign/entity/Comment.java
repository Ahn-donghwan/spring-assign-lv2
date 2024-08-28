package com.sparta.springlv2assign.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Comment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String contents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_Id")
    private Todo todo;  // db 내부적으로는 todo_id

    public Comment(String contents, Todo todo) {
        this.contents = contents;
        this.todo = todo;
    }
}
