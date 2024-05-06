package com.candenizgumus.springbootquizapp.services;

import com.candenizgumus.springbootquizapp.dto.request.QuestionSaveDto;

import com.candenizgumus.springbootquizapp.dto.response.QuestionFindAnswerOfQuestionDto;
import com.candenizgumus.springbootquizapp.entities.Answer;
import com.candenizgumus.springbootquizapp.entities.CorrectAnswer;
import com.candenizgumus.springbootquizapp.entities.Question;
import com.candenizgumus.springbootquizapp.entities.Quiz;
import com.candenizgumus.springbootquizapp.exceptions.ErrorType;
import com.candenizgumus.springbootquizapp.exceptions.QuizAppException;

import com.candenizgumus.springbootquizapp.repositories.QuestionRepository;
import com.candenizgumus.springbootquizapp.repositories.QuizRepository;
import com.candenizgumus.springbootquizapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionService extends ServiceManager<Question,Long>
{
    //Bu katmanda başka sınıfların repositorylerini enjekte ettim çünkü service katmanını enjekte ettiğimde serviceler sonsuz döngüye giriyor.
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    private final CorrectAnswerService correctAnswerService;
    private final AnswerService answerService;

    public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository, CorrectAnswerService correctAnswerService, AnswerService answerService)
    {
        super(questionRepository);
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
        this.correctAnswerService = correctAnswerService;
        this.answerService = answerService;
    }

    public List<Question> findAllByQuiz_Id(Long id){
        return questionRepository.findAllByQuiz_Id(id);
    }

    /**
     * QuestionId'si verilen soruyu databasede bulur ve döndürür. Soru yoksa hata fırlatır. Soru ile ilgili correctAnswer ve answer bilgilerini birleştirip
     * DTO formatında döndürür.
     * @param questionId aranan Question'ın id'si.
     * @return QuestionFindAnswerOfQuestionDto JSON formatında döndürür.
     */
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

    /**
     * Gonderilen DTO nesnesi database'e kaydeder. Girilen questionId ile arama yapar ve database'de yoksa hata fırlatır.
     * @param dto kaydedilecek olan dto nesnesi.
     * @return Question'ı döndürür.
     */
    public Question saveDto(QuestionSaveDto dto)
    {
        Quiz quiz = quizRepository.findById(dto.quizId()).orElseThrow(() -> new QuizAppException(ErrorType.QUESTION_NOT_FOUND));

        Question question = Question.builder()
                .content(dto.content())
                .quiz(quiz)
                .build();

        return questionRepository.save(question);
    }
}
