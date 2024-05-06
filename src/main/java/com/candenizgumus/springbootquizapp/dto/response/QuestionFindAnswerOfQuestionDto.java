package com.candenizgumus.springbootquizapp.dto.response;

import java.util.List;

public record QuestionFindAnswerOfQuestionDto(String question , List<String> answers, List<String> correctanswers)
{
}
