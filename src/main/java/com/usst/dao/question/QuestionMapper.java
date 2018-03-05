package com.usst.dao.question;

import com.usst.entity.question.Question;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface QuestionMapper {
    int deleteByPrimaryKey(String questionId);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(String questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

    ArrayList<Question> selectAllRecordsByUserId(String userId);

    int updateQSIdByPrimaryKey(@Param("questionSetId") String questionSetId, @Param("questionId") String questionId);
}