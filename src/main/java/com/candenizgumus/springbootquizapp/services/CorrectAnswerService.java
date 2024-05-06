package com.candenizgumus.springbootquizapp.services;

import com.candenizgumus.springbootquizapp.dto.request.CorrectAnswerSaveDto;
import com.candenizgumus.springbootquizapp.entities.Answer;
import com.candenizgumus.springbootquizapp.entities.CorrectAnswer;
import com.candenizgumus.springbootquizapp.entities.Question;
import com.candenizgumus.springbootquizapp.exceptions.ErrorType;
import com.candenizgumus.springbootquizapp.exceptions.QuizAppException;
import com.candenizgumus.springbootquizapp.repositories.AnswerRepository;
import com.candenizgumus.springbootquizapp.repositories.CorrectAnswerRepository;
import com.candenizgumus.springbootquizapp.repositories.QuestionRepository;
import com.candenizgumus.springbootquizapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrectAnswerService extends ServiceManager<CorrectAnswer,Long>
{
    //Bu katmanda başka sınıfların repositorylerini enjekte ettim çünkü service katmanını enjekte ettiğimde serviceler sonsuz döngüye giriyor.
    private final CorrectAnswerRepository correctAnswerRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public CorrectAnswerService(CorrectAnswerRepository correctAnswerRepository, QuestionRepository questionRepository, AnswerRepository answerRepository)
    {
        super(correctAnswerRepository);
        this.correctAnswerRepository = correctAnswerRepository;
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
    }

    /**
     * Gonderilen question id'si ile eşleşen bütün correctAnswer'ları getirir.
     * @param questionId aranan question id'si.
     * @return correctAnswer listesi olarak döner.
     */
    public List<CorrectAnswer> findAllByQuestion_Id(Long questionId){
        return correctAnswerRepository.findAllByQuestion_Id(questionId);
    }

    /**
     * Gonderilen DTO nesnesi database'e kaydeder. Girilen questionId ve answerId arama yapar ve database'de yoksa hata fırlatır.
     * @param dto kaydedilecek olan dto nesnesi.
     * @return CorrectAnswer'ı döndürür.
     */
    public CorrectAnswer saveDto(CorrectAnswerSaveDto dto)
    {
        Answer answer = answerRepository.findById(dto.answerId()).orElseThrow(() -> new QuizAppException(ErrorType.ANSWER_NOT_FOUND));
        Question question = questionRepository.findById(dto.questionId()).orElseThrow(() -> new QuizAppException(ErrorType.QUESTION_NOT_FOUND));

        CorrectAnswer correctAnswer = CorrectAnswer.builder()
                .correctanswer(answer)
                .question(question)
                .build();
        return correctAnswerRepository.save(correctAnswer);
    }
}
