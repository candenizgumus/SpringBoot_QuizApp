package com.candenizgumus.springbootquizapp.services;

import com.candenizgumus.springbootquizapp.dto.response.QuizFindAllDto;
import com.candenizgumus.springbootquizapp.entities.Question;
import com.candenizgumus.springbootquizapp.entities.Quiz;
import com.candenizgumus.springbootquizapp.repositories.QuestionRepository;
import com.candenizgumus.springbootquizapp.repositories.QuizRepository;
import com.candenizgumus.springbootquizapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService extends ServiceManager<Quiz,Long>
{
    private final QuizRepository quizRepository;
    private final QuestionService questionService;

    public QuizService(QuizRepository quizRepository, QuestionService questionService)
    {
        super(quizRepository);
        this.quizRepository = quizRepository;
        this.questionService = questionService;
    }

    /**
     * Database'den bütün quiz ve ilgili sorularını DTO formatında döndürür.
     * @return List<QuizFindAllDto> listesini JSON formatında döndürür.
     */
    public List<QuizFindAllDto> findAllDto() {
        List<Quiz> allQuizes = quizRepository.findAll();
        List<QuizFindAllDto> newQuizFindAllDtoList = new ArrayList<>();

        for (Quiz quiz : allQuizes) {
            List<Question> questionsInQuiz = questionService.findAllByQuiz_Id(quiz.getId());
            QuizFindAllDto quizFindAllDto = new QuizFindAllDto(quiz.getQuizname(), questionsInQuiz.stream().map(Question::getContent).collect(Collectors.toList()));
            newQuizFindAllDtoList.add(quizFindAllDto);
        }

        return newQuizFindAllDtoList;
    }

}
