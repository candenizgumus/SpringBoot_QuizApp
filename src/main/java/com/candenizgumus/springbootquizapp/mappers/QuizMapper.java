package com.candenizgumus.springbootquizapp.mappers;




import com.candenizgumus.springbootquizapp.dto.request.QuizSaveDto;
import com.candenizgumus.springbootquizapp.entities.Quiz;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface QuizMapper
{
    QuizMapper INSTANCE = Mappers.getMapper( QuizMapper.class );

    Quiz quizSaveDtoToQuiz(QuizSaveDto quizSaveDto);



}
