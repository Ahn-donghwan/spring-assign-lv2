package com.sparta.springlv2assign.repository;

import com.sparta.springlv2assign.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
