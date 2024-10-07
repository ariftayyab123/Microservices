package com.question.QuestionService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String question;
    private  Long quizId;
    @Column(name = "uploaded_via")
    private int uploadedVia;
}
