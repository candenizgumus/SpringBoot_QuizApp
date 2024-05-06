package com.candenizgumus.springbootquizapp.controllers;

import com.candenizgumus.springbootquizapp.dto.request.QuestionSaveDto;
import com.candenizgumus.springbootquizapp.dto.request.QuizSaveDto;
import com.candenizgumus.springbootquizapp.dto.response.QuestionFindAnswerOfQuestionDto;
import com.candenizgumus.springbootquizapp.entities.CorrectAnswer;
import com.candenizgumus.springbootquizapp.entities.Question;
import com.candenizgumus.springbootquizapp.entities.Quiz;
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

    /**
     * Gonderilen nesneyi database'e kaydeder.
     * @param question kaydedilecek olan nesne
     * @return question'ı JSON formatında döndürür.
     */
    @PostMapping(SAVE)
    public ResponseEntity<Question> save(@RequestBody Question question){
        return ResponseEntity.ok(questionService.save(question));
    }
    /**
     * Gonderilen DTO formatındaki verileri database'e kaydeder.
     * @param dto kaydedilecek olan nesne.
     * @return Question'ı JSON formatında döndürür.
     */
    @PostMapping(SAVEDTO)
    public ResponseEntity<Question> saveDto(@RequestBody QuestionSaveDto dto){
        return ResponseEntity.ok(questionService.saveDto(dto));
    }

    /**
     * Bütün soruları ve ilgili cevaplarını database'den DTO formatında döndürür..
     * @return QuestionFindAnswerOfQuestionDto jSON formatında döndürür.
     */
    @GetMapping(FINDANSWERANDCORRECTANSWEROFQUESTION)
    public ResponseEntity<QuestionFindAnswerOfQuestionDto> findAnswerAndCorrectAnswerOfQuestion(Long questionId){
        return ResponseEntity.ok(questionService.findAnswerAndCorrectAnswerOfQuestion(questionId));
    }
}
