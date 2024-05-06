package com.candenizgumus.springbootquizapp.repositories;

import com.candenizgumus.springbootquizapp.entities.CorrectAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorrectAnswerRepository extends JpaRepository<CorrectAnswer,Long>
{
    List<CorrectAnswer> findAllByQuestion_Id(Long questionId);
}
