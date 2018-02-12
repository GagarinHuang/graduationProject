package com.usst.dao.question;

import com.usst.entity.question.Question;

import java.util.ArrayList;

public interface QuestionMapper {
    int deleteByPrimaryKey(String questionId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(String questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    ArrayList<Question> selectAllRecordsByUserId(String userId);
}