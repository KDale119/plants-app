package com.mccneb.edu.demo.repository;

import com.mccneb.edu.demo.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findCommentsByPlantId(Integer plantId);
}
