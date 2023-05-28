package com.sandy.student.repositories;


import com.sandy.student.entities.AnswerSheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerSheetRepository extends JpaRepository<AnswerSheetEntity, Long> {
}
