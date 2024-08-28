package com.sparta.springlv2assign.repository;

import com.sparta.springlv2assign.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
