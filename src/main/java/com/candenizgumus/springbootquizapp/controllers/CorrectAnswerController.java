package com.candenizgumus.springbootquizapp.controllers;

import com.candenizgumus.springbootquizapp.entities.Answer;
import com.candenizgumus.springbootquizapp.entities.CorrectAnswer;
import com.candenizgumus.springbootquizapp.services.CorrectAnswerService;
import com.candenizgumus.springbootquizapp.services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.candenizgumus.springbootquizapp.Constants.EndPoints.*;

@RequestMapping(CORRECTANSWER)
@RestController
@RequiredArgsConstructor
public class CorrectAnswerController
{
    private final CorrectAnswerService correctAnswerService;

    @PostMapping(SAVE)
    public ResponseEntity<CorrectAnswer> save(@RequestBody CorrectAnswer correctAnswer){
        return ResponseEntity.ok(correctAnswerService.save(correctAnswer));
    }
}
