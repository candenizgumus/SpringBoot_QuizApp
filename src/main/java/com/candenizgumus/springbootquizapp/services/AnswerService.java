package com.candenizgumus.springbootquizapp.services;

import com.candenizgumus.springbootquizapp.dto.request.AnswerSaveDto;
import com.candenizgumus.springbootquizapp.entities.Answer;
import com.candenizgumus.springbootquizapp.entities.CorrectAnswer;
import com.candenizgumus.springbootquizapp.entities.Question;
import com.candenizgumus.springbootquizapp.exceptions.ErrorType;
import com.candenizgumus.springbootquizapp.exceptions.QuizAppException;
import com.candenizgumus.springbootquizapp.repositories.AnswerRepository;
import com.candenizgumus.springbootquizapp.repositories.QuestionRepository;
import com.candenizgumus.springbootquizapp.utility.ServiceManager;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService extends ServiceManager<Answer,Long>
{
    //Bu katmanda başka sınıfların repositorylerini enjekte ettim çünkü service katmanını enjekte ettiğimde serviceler sonsuz döngüye giriyor.
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;


    public AnswerService(AnswerRepository answerRepository, QuestionRepository questionRepository)
    {
        super(answerRepository);
        this.answerRepository = answerRepository;

        this.questionRepository = questionRepository;
    }

    /**
     * Gonderilen question id'si ile eşleşen bütün answer'ları getirir.
     * @param questionId aranan question id'si.
     * @return Answer listesi olarak döner.
     */
    public List<Answer> findAllByQuestion_Id(Long questionId){
        return answerRepository.findAllByQuestion_Id(questionId);
    }

    /**
     * Gonderilen DTO nesnesi database'e kaydeder. Girilen questionId ile arama yapar ve database'de yoksa hata fırlatır.
     * @param dto kaydedilecek olan dto nesnesi.
     * @return Answer'ı döndürür.
     */
    public Answer saveDto(AnswerSaveDto dto)
    {
        Question question = questionRepository.findById(dto.questionId()).orElseThrow(() -> new QuizAppException(ErrorType.QUESTION_NOT_FOUND));

        Answer answer = Answer.builder()
                .question(question)
                .answer(dto.answer())
                .build();

        return answerRepository.save(answer);
    }
}
