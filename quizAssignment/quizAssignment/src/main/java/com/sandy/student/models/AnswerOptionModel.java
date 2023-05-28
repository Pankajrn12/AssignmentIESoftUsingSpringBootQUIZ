package com.sandy.student.models;

public class AnswerOptionModel {
    private String ansId;
    private String answerText;
    private String isCorrect;

    public String getAnsId() {
        return ansId;
    }

    public void setAnsId(String ansId) {
        this.ansId = ansId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect;
    }

    @Override
    public String toString() {
        return "AnswerOptionModel{" +
                "ansId='" + ansId + '\'' +
                ", answerText='" + answerText + '\'' +
                ", isCorrect='" + isCorrect + '\'' +
                '}';
    }
}
