package com.sandy.student.entities;

import com.fasterxml.jackson.databind.DatabindException;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class QuizEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long quizId;
    private String quizName;
    @Temporal(TemporalType.DATE)
    private Date quizStartDate;
    @Temporal(TemporalType.DATE)
    private Date quizEndDate;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "quizId")
    private List<QuestionEntity> questions;
    private String status;

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public Date getQuizStartDate() {
        return quizStartDate;
    }

    public void setQuizStartDate(Date quizStartDate) {
        this.quizStartDate = quizStartDate;
    }

    public Date getQuizEndDate() {
        return quizEndDate;
    }

    public void setQuizEndDate(Date quizEndDate) {
        this.quizEndDate = quizEndDate;
    }

    public List<QuestionEntity> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionEntity> questions) {
        this.questions = questions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "QuizEntity{" +
                "quizId=" + quizId +
                ", quizName='" + quizName + '\'' +
                ", quizStartDate=" + quizStartDate +
                ", quizEndDate=" + quizEndDate +
                ", questions=" + questions +
                ", status='" + status + '\'' +
                '}';
    }
}
