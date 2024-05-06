package com.candenizgumus.springbootquizapp.services;

import com.candenizgumus.springbootquizapp.entities.Answer;
import com.candenizgumus.springbootquizapp.entities.CorrectAnswer;
import com.candenizgumus.springbootquizapp.repositories.AnswerRepository;
import com.candenizgumus.springbootquizapp.repositories.CorrectAnswerRepository;
import com.candenizgumus.springbootquizapp.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorrectAnswerService extends ServiceManager<CorrectAnswer,Long>
{
    private final CorrectAnswerRepository correctAnswerRepository;

    public CorrectAnswerService(CorrectAnswerRepository correctAnswerRepository)
    {
        super(correctAnswerRepository);
        this.correctAnswerRepository = correctAnswerRepository;
    }

    public List<CorrectAnswer> findAllByQuestion_Id(Long questionId){
        return correctAnswerRepository.findAllByQuestion_Id(questionId);
    }
}
