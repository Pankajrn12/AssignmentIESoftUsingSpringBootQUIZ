package com.sandy.student.resources;

import com.sandy.student.models.AnswerSheetModel;
import com.sandy.student.models.QuizModel;
import com.sandy.student.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizResource {
    @Autowired
    QuizService quizService;
    @PostMapping("/saveQuizWithQuestionsAndTheirOption")
    public ResponseEntity saveQuizWithQuestionsAndTheirOption(@RequestBody QuizModel quizModel) throws ParseException {
        return quizService.saveQuizWithQuestionsAndTheirOption(quizModel);
    }

    // created By Pankaj Kumar Gupta
    @GetMapping("/getAllQuizWithActiveStatus")
    public List<QuizModel> getAllQuizWithActiveStatus(){
        return quizService.getAllQuizWithActiveStatus();
    }

    @PostMapping("/saveAnswerByUser")
    public ResponseEntity saveAnswerByUser(@RequestBody AnswerSheetModel answerSheetModel){
        return quizService.saveAnswerByUser(answerSheetModel);
    }

}
