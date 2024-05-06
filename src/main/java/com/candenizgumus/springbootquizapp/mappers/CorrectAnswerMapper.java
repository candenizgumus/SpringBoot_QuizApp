package com.candenizgumus.springbootquizapp.mappers;




import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CorrectAnswerMapper
{
    CorrectAnswerMapper INSTANCE = Mappers.getMapper( CorrectAnswerMapper.class );





}
