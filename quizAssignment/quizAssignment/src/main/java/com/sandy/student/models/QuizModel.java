package com.sandy.student.models;

import java.util.List;

public class QuizModel {
    private Long quizId;
    private String quizName;
    private String quizStartDate;
    private String quizEndDate;
    private List<QuestionModel> questions;
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

    public String getQuizStartDate() {
        return quizStartDate;
    }

    public void setQuizStartDate(String quizStartDate) {
        this.quizStartDate = quizStartDate;
    }

    public String getQuizEndDate() {
        return quizEndDate;
    }

    public void setQuizEndDate(String quizEndDate) {
        this.quizEndDate = quizEndDate;
    }

    public List<QuestionModel> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionModel> questions) {
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
        return "QuizModel{" +
                "quizId=" + quizId +
                ", quizName='" + quizName + '\'' +
                ", quizStartDate='" + quizStartDate + '\'' +
                ", quizEndDate='" + quizEndDate + '\'' +
                ", questions=" + questions +
                ", status='" + status + '\'' +
                '}';
    }
}
