package com.candenizgumus.springbootquizapp.controllers;

import static com.candenizgumus.springbootquizapp.Constants.EndPoints.*;

import com.candenizgumus.springbootquizapp.entities.Answer;
import com.candenizgumus.springbootquizapp.services.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(ANSWER)
@RestController
@RequiredArgsConstructor
public class AnswerController
{
    private final AnswerService answerService;

    @PostMapping(SAVE)
    public ResponseEntity<Answer> save(@RequestBody Answer answer){
        return ResponseEntity.ok(answerService.save(answer));
    }
}
