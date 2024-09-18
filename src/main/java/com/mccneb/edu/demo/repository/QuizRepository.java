package com.mccneb.edu.demo.repository;

import com.mccneb.edu.demo.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    Quiz findByQuizId(Integer quizId);
    List<Quiz> findByUserName(String userName);
}
