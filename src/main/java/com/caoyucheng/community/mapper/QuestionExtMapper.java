package com.caoyucheng.community.mapper;

import com.caoyucheng.community.dto.QuestionQueryDTO;
import com.caoyucheng.community.model.Question;

import java.util.List;

/**
 * @author caoyucheng on 2020/8/5
 */
public interface QuestionExtMapper {
    int incView(Question record);

    int incCommentCount(Question record);

    List<Question> selectRelated(Question question);

    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}