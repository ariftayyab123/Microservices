package com.question.QuestionService.controllers;

import com.question.QuestionService.entities.Question;
import com.question.QuestionService.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // Create
    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    // Count questions by uploadedVia
    @GetMapping("/question-count")
    public ResponseEntity<Long> countQuestionsByUploadedVia(@RequestParam("uploadedVia") int uploadedVia) {
        try {
            long count = questionService.countQuestionsByUploadedVia(uploadedVia);
            return ResponseEntity.ok(count);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }


    // Get all questions
    @GetMapping
    public List<Question> getAll() {
        return questionService.get();
    }

    // Get question by ID
    @GetMapping("/{questionId}")
    public Question getOne(@PathVariable Long questionId) {
        return questionService.getOne(questionId);
    }

    // Get all questions of a specific quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId) {
        return questionService.getQuestionsOfQuiz(quizId);
    }
}
