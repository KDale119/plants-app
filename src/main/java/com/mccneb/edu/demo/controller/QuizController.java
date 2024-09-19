package com.mccneb.edu.demo.controller;

import com.mccneb.edu.demo.model.Quiz;
import com.mccneb.edu.demo.model.QuizResultsResponseDTO;
import com.mccneb.edu.demo.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping()
    public ResponseEntity<QuizResultsResponseDTO> quizResults(@RequestBody Quiz results) {
        return quizService.quizResults(results);
    }


    @GetMapping("/{quizId}")
    public ResponseEntity<QuizResultsResponseDTO> getQuizById(@PathVariable Integer quizId) {
        Optional<QuizResultsResponseDTO> quiz = Optional.ofNullable(quizService.findQuizById(quizId));
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/results/{userName}")
    public ResponseEntity<List<QuizResultsResponseDTO>> getQuizByUserName(@PathVariable String userName) {
        List<QuizResultsResponseDTO> quiz = quizService.findQuizByUserName(userName);
        if (quiz.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(quiz);
    }
}
