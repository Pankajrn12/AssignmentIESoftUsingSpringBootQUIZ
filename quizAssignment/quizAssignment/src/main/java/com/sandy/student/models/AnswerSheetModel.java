package com.sandy.student.models;


import java.util.List;

public class AnswerSheetModel {
    private String id;
    private String quizId;
    private String userId;
    private List<QuestionAnswerModel> answersWithQuestion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public List<QuestionAnswerModel> getAnswersWithQuestion() {
        return answersWithQuestion;
    }

    public void setAnswersWithQuestion(List<QuestionAnswerModel> answersWithQuestion) {
        this.answersWithQuestion = answersWithQuestion;
    }

    @Override
    public String toString() {
        return "AnswerSheetModel{" +
                "id='" + id + '\'' +
                ", quizId='" + quizId + '\'' +
                ", userId='" + userId + '\'' +
                ", answersWithQuestion=" + answersWithQuestion +
                '}';
    }
}
