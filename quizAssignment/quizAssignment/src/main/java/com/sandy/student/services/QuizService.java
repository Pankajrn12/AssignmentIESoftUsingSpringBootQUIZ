package com.sandy.student.services;

import com.sandy.student.entities.*;
import com.sandy.student.models.AnswerOptionModel;
import com.sandy.student.models.AnswerSheetModel;
import com.sandy.student.models.QuestionModel;
import com.sandy.student.models.QuizModel;
import com.sandy.student.repositories.AnswerOptionRepository;
import com.sandy.student.repositories.AnswerSheetRepository;
import com.sandy.student.repositories.QuestionRepository;
import com.sandy.student.repositories.QuizRepository;
import com.sandy.student.utilities.DateUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerOptionRepository answerOptionRepository;
    @Autowired
    EntityManager em;
    @Autowired
    AnswerSheetRepository answerSheetRepository;

    @Transactional
    public ResponseEntity saveQuizWithQuestionsAndTheirOption(QuizModel quizModel) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("quizModel==============>" + quizModel);
        List<QuestionEntity> questionEntityList = new ArrayList<>();
        quizModel.getQuestions().stream().forEach(data -> {
            QuestionEntity questionEntity = new QuestionEntity();
            questionEntity.setQuestionText(data.getQuestionText());
            questionEntity.setQuestionMark(data.getQuestionMark());
            List<AnswerOptionEntity> answerOptionEntityList = new ArrayList<>();
            data.getOptions().stream().forEach(data1 -> {
                AnswerOptionEntity answerOptionEntity = new AnswerOptionEntity();
                answerOptionEntity.setAnswerText(data1.getAnswerText());
                answerOptionEntity.setIsCorrect(data1.getIsCorrect());
                answerOptionEntityList.add(answerOptionEntity);
            });
            questionEntity.setOptions(answerOptionEntityList);
            questionEntityList.add(questionEntity);
        });
        // Created By Pankaj Kumar Gupta
        QuizEntity quizEntity = new QuizEntity();
        quizEntity.setQuizName(quizModel.getQuizName());
        quizEntity.setQuizStartDate(sdf.parse(quizModel.getQuizStartDate()));
        quizEntity.setQuizEndDate(sdf.parse(quizModel.getQuizEndDate()));
//        quizEntity.setQuizEndDate(quizModel.getQuizStartDate());
//        quizEntity.setQuizStartDate(quizModel.getQuizStartDate());
        quizEntity.setStatus("Active");
        quizEntity.setQuestions(questionEntityList);
        quizRepository.save(quizEntity);
        return new ResponseEntity<>("data is saved successfully", HttpStatus.OK);
    }

    public List<QuizModel> getAllQuizWithActiveStatus() {
        List<QuizEntity> quizEntityList = quizRepository.findAll().stream().filter(data-> data.getStatus().equalsIgnoreCase("Active")).collect(Collectors.toList());
        List<QuizModel> quizModelList = new ArrayList<>();
        quizEntityList.stream().forEach(quiz -> {
            List<QuestionModel> questionModelList = new ArrayList<>();
            quiz.getQuestions().stream().forEach(question -> {
                QuestionModel questionModel = new QuestionModel();
                List<AnswerOptionModel> answerOptionModelList = new ArrayList<>();
                question.getOptions().stream().forEach(answer -> {
                    AnswerOptionModel answerOptionModel = new AnswerOptionModel();
                    answerOptionModel.setAnswerText(answer.getAnswerText());
                    answerOptionModel.setAnsId(answer.getAnsId().toString());
                    answerOptionModel.setIsCorrect(answer.getIsCorrect());
                    answerOptionModelList.add(answerOptionModel);
                });

                // Created By Pankaj Kumar Gupta
                questionModel.setQuestionId(question.getQuestionId());
                questionModel.setQuestionText(question.getQuestionText());
                questionModel.setQuestionMark(question.getQuestionMark());
                questionModel.setOptions(answerOptionModelList);
                questionModelList.add(questionModel);
            });
            QuizModel quizModel = new QuizModel();
            quizModel.setQuizId(quiz.getQuizId());
            quizModel.setQuizName(quiz.getQuizName());
            quizModel.setQuizStartDate(quiz.getQuizStartDate().toString());
            quizModel.setQuizEndDate(quiz.getQuizEndDate().toString());
            quizModel.setStatus(quiz.getStatus());
            quizModel.setQuestions(questionModelList);
            quizModelList.add(quizModel);
        });
        return quizModelList;
    }
    @Transactional
    public ResponseEntity saveAnswerByUser(AnswerSheetModel answerSheetModel) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        QuizEntity quizEntity = quizRepository.findByQuizId(Long.valueOf(answerSheetModel.getQuizId()));
        if (quizEntity.getQuizEndDate().before(DateUtility.getCurrentDate())) {
            task(answerSheetModel);
            return new ResponseEntity<>("submitted", HttpStatus.OK);
        } else {
            quizEntity.setStatus("Inactive");
            quizRepository.save(quizEntity);
            return new ResponseEntity<>("You are late for this quiz", HttpStatus.FORBIDDEN);
        }
    }

    // Created By Pankaj Kumar Gupta
    @Transactional
    @Scheduled(cron="0 38 16 17 * *")
    public void task(AnswerSheetModel answerSheetModel){
            AnswerSheetEntity answerSheetEntity = new AnswerSheetEntity();
            answerSheetEntity.setQuizId(answerSheetModel.getQuizId());
            List<QuestionAnswerEntity> questionAnswerEntityList = new ArrayList<>();
            answerSheetModel.getAnswersWithQuestion().stream().forEach(data ->{
                QuestionAnswerEntity questionAnswerEntity = new QuestionAnswerEntity();
                questionAnswerEntity.setAnswerId(data.getAnswerId());
                questionAnswerEntity.setQuestionId(data.getQuestionId());
                questionAnswerEntityList.add(questionAnswerEntity);
            });
            answerSheetEntity.setAnswersWithQuestion(questionAnswerEntityList);
            answerSheetEntity.setUserId(answerSheetModel.getUserId());
            answerSheetRepository.save(answerSheetEntity);

    }
}
