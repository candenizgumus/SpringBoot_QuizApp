package com.candenizgumus.springbootquizapp.mappers;




import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnswerMapper
{
    AnswerMapper INSTANCE = Mappers.getMapper( AnswerMapper.class );





}
