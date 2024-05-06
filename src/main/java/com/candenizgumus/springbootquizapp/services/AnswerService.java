package com.candenizgumus.springbootquizapp.services;

import com.candenizgumus.springbootquizapp.entities.Answer;
import com.candenizgumus.springbootquizapp.entities.CorrectAnswer;
import com.candenizgumus.springbootquizapp.repositories.AnswerRepository;
import com.candenizgumus.springbootquizapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService extends ServiceManager<Answer,Long>
{
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository)
    {
        super(answerRepository);
        this.answerRepository = answerRepository;
    }

    public List<Answer> findAllByQuestion_Id(Long questionId){
        return answerRepository.findAllByQuestion_Id(questionId);
    }
}
