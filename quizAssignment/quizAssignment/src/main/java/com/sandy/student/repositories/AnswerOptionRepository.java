package com.sandy.student.repositories;


import com.sandy.student.entities.AnswerOptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerOptionRepository extends JpaRepository<AnswerOptionEntity, Long> {
}
