package com.sandy.student.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class AnswerSheetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String quizId;
    private String userId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "answerSheetId")
    private List<QuestionAnswerEntity> answersWithQuestion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<QuestionAnswerEntity> getAnswersWithQuestion() {
        return answersWithQuestion;
    }

    public void setAnswersWithQuestion(List<QuestionAnswerEntity> answersWithQuestion) {
        this.answersWithQuestion = answersWithQuestion;
    }

    @Override
    public String toString() {
        return "AnswerSheetEntity{" +
                "id=" + id +
                ", quizId='" + quizId + '\'' +
                ", userId='" + userId + '\'' +
                ", answersWithQuestion=" + answersWithQuestion +
                '}';
    }
}
