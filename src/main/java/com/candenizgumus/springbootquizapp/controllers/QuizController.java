package com.candenizgumus.springbootquizapp.controllers;

import com.candenizgumus.springbootquizapp.dto.request.QuizSaveDto;
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

    /**
     * Gonderilen nesneyi database'e kaydeder.
     * @param quiz kaydedilecek olan nesne
     * @return quiz'i JSON formatında döndürür.
     */
    @PostMapping(SAVE)
    public ResponseEntity<Quiz> save(@RequestBody Quiz quiz){
        return ResponseEntity.ok(quizService.save(quiz));
    }

    /**
     * Gonderilen DTO formatındaki verileri database'e kaydeder.
     * @param dto kaydedilecek olan nesne.
     * @return Quiz'i JSON formatında döndürür.
     */
    @PostMapping(SAVEDTO)
    public ResponseEntity<Quiz> saveDto(@RequestBody QuizSaveDto dto){
        return ResponseEntity.ok(quizService.saveDto(dto));
    }

    /**
     * Bütün verileri database'den DTO formatında getirir..
     * @return QuizFindAllDto jSON formatında döndürür.
     */
    @GetMapping(FINDALLDTO)
    public ResponseEntity<List<QuizFindAllDto>> findAllDto(){
        return ResponseEntity.ok(quizService.findAllDto());
    }
}
