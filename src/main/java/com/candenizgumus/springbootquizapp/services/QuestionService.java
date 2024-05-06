package com.candenizgumus.springbootquizapp.services;

import com.candenizgumus.springbootquizapp.dto.response.QuestionFindAnswerOfQuestionDto;
import com.candenizgumus.springbootquizapp.entities.Answer;
import com.candenizgumus.springbootquizapp.entities.CorrectAnswer;
import com.candenizgumus.springbootquizapp.entities.Question;
import com.candenizgumus.springbootquizapp.exceptions.ErrorType;
import com.candenizgumus.springbootquizapp.exceptions.QuizAppException;
import com.candenizgumus.springbootquizapp.repositories.CorrectAnswerRepository;
import com.candenizgumus.springbootquizapp.repositories.QuestionRepository;
import com.candenizgumus.springbootquizapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService extends ServiceManager<Question,Long>
{
    private final QuestionRepository questionRepository;
    private final CorrectAnswerService correctAnswerService;
    private final AnswerService answerService;

    public QuestionService(QuestionRepository questionRepository, CorrectAnswerService correctAnswerService, AnswerService answerService)
    {
        super(questionRepository);
        this.questionRepository = questionRepository;
        this.correctAnswerService = correctAnswerService;
        this.answerService = answerService;
    }

    public List<Question> findAllByQuiz_Id(Long id){
        return questionRepository.findAllByQuiz_Id(id);
    }

    public QuestionFindAnswerOfQuestionDto findAnswerAndCorrectAnswerOfQuestion(Long questionId)
    {
        Question question = questionRepository.findById(questionId).orElseThrow(() -> new QuizAppException(ErrorType.QUESTION_NOT_FOUND));
        List<CorrectAnswer> correctAnswers = correctAnswerService.findAllByQuestion_Id(questionId);
        List<Answer> answers = answerService.findAllByQuestion_Id(questionId);

        QuestionFindAnswerOfQuestionDto finalList = new QuestionFindAnswerOfQuestionDto(
                question.getContent(),
                answers.stream().map(Answer::getAnswer).collect(Collectors.toList()),
                correctAnswers.stream().map(correctAnswer -> correctAnswer.getCorrectanswer().getAnswer()).collect(Collectors.toList())
        );

        return finalList;

    }
}
