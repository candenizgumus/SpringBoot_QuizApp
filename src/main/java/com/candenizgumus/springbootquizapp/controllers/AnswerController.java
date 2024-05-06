package com.candenizgumus.springbootquizapp.controllers;

import static com.candenizgumus.springbootquizapp.Constants.EndPoints.*;

import com.candenizgumus.springbootquizapp.dto.request.AnswerSaveDto;
import com.candenizgumus.springbootquizapp.dto.request.CorrectAnswerSaveDto;
import com.candenizgumus.springbootquizapp.entities.Answer;
import com.candenizgumus.springbootquizapp.entities.CorrectAnswer;
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

    /**
     * Gonderilen nesneyi database'e kaydeder.
     * @param answer kaydedilecek olan nesne
     * @return Answer'ı JSON formatında döndürür.
     */
    @PostMapping(SAVE)
    public ResponseEntity<Answer> save(@RequestBody Answer answer){
        return ResponseEntity.ok(answerService.save(answer));
    }

    /**
     * Gonderilen DTO formatındaki verileri database'e kaydeder.
     * @param dto kaydedilecek olan nesne.
     * @return Answer'ı JSON formatında döndürür.
     */
    @PostMapping(SAVEDTO)
    public ResponseEntity<Answer> saveDto(@RequestBody AnswerSaveDto dto){
        return ResponseEntity.ok(answerService.saveDto(dto));
    }
}
