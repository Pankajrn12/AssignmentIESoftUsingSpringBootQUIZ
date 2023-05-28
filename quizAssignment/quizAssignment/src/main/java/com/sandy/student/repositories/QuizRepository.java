package com.sandy.student.repositories;


import com.sandy.student.entities.QuizEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<QuizEntity, Long> {
    QuizEntity findByQuizId(Long quizId);
}
