package com.candenizgumus.springbootquizapp.controllers;

import com.candenizgumus.springbootquizapp.dto.response.QuizFindAllDto;
import com.candenizgumus.springbootquizapp.entities.Question;
import com.candenizgumus.springbootquizapp.entities.Quiz;
import com.candenizgumus.springbootquizapp.services.QuestionService;
import com.candenizgumus.springbootquizapp.services.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.candenizgumus.springbootquizapp.Constants.EndPoints.*;

@RequestMapping(QUIZ)
@RestController
@RequiredArgsConstructor
public class QuizController
{
    private final QuizService quizService;

    @PostMapping(SAVE)
    public ResponseEntity<Quiz> save(@RequestBody Quiz quiz){
        return ResponseEntity.ok(quizService.save(quiz));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<QuizFindAllDto>> findAllDto(){
        return ResponseEntity.ok(quizService.findAllDto());
    }
}
