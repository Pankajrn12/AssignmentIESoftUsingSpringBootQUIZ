package com.sandy.student.models;

public class QuestionAnswerModel {
    private String questionId;
    private String answerId;
    private String totalMarks;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(String totalMarks) {
        this.totalMarks = totalMarks;
    }

    @Override
    public String toString() {
        return "QuestionAnswerModel{" +
                "questionId='" + questionId + '\'' +
                ", answerId='" + answerId + '\'' +
                ", totalMarks='" + totalMarks + '\'' +
                '}';
    }
}
