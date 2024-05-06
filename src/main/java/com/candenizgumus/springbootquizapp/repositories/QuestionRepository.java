package com.candenizgumus.springbootquizapp.repositories;

import com.candenizgumus.springbootquizapp.entities.Answer;
import com.candenizgumus.springbootquizapp.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>
{
    List<Question> findAllByQuiz_Id(Long id);


}
