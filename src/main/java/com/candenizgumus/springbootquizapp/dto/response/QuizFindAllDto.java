package com.candenizgumus.springbootquizapp.dto.response;

import com.candenizgumus.springbootquizapp.entities.Question;

import java.util.List;

public record QuizFindAllDto(String quizname, List<String> questions)
{
}
