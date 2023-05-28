package com.sandy.student.models;


import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

public class QuestionModel {
    private Long questionId;
    private String questionText;
    private String questionMark;
    private List<AnswerOptionModel> options;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionMark() {
        return questionMark;
    }

    public void setQuestionMark(String questionMark) {
        this.questionMark = questionMark;
    }

    public List<AnswerOptionModel> getOptions() {
        return options;
    }

    public void setOptions(List<AnswerOptionModel> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "QuestionModel{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", questionMark='" + questionMark + '\'' +
                ", options=" + options +
                '}';
    }
}
