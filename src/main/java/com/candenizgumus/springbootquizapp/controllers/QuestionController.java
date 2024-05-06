package com.candenizgumus.springbootquizapp.controllers;

import com.candenizgumus.springbootquizapp.dto.response.QuestionFindAnswerOfQuestionDto;
import com.candenizgumus.springbootquizapp.entities.CorrectAnswer;
import com.candenizgumus.springbootquizapp.entities.Question;
import com.candenizgumus.springbootquizapp.services.AnswerService;
import com.candenizgumus.springbootquizapp.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.candenizgumus.springbootquizapp.Constants.EndPoints.*;

@RequestMapping(QUESTION)
@RestController
@RequiredArgsConstructor
public class QuestionController
{
    private final QuestionService questionService;

    @PostMapping(SAVE)
    public ResponseEntity<Question> save(@RequestBody Question question){
        return ResponseEntity.ok(questionService.save(question));
    }

    @GetMapping(FINDANSWERANDCORRECTANSWEROFQUESTION)
    public ResponseEntity<QuestionFindAnswerOfQuestionDto> findAnswerAndCorrectAnswerOfQuestion(Long questionId){
        return ResponseEntity.ok(questionService.findAnswerAndCorrectAnswerOfQuestion(questionId));
    }
}
