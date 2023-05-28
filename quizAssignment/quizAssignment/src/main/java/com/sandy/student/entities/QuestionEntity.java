package com.sandy.student.entities;


import javax.persistence.*;
import java.util.List;

@Entity
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long questionId;
    private String questionText;
    private String questionMark;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId")
    private List<AnswerOptionEntity> options;

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

    public List<AnswerOptionEntity> getOptions() {
        return options;
    }

    public void setOptions(List<AnswerOptionEntity> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "QuestionEntity{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", questionMark='" + questionMark + '\'' +
                ", options=" + options +
                '}';
    }
}
