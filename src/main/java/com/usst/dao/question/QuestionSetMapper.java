package com.usst.dao.question;

import com.usst.entity.question.QuestionSet;
import com.usst.entity.question.QuestionSetKey;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface QuestionSetMapper {
    int deleteByPrimaryKey(QuestionSetKey key);

    int insert(QuestionSet record);

    int insertSelective(QuestionSet record);

    QuestionSet selectByPrimaryKey(QuestionSetKey key);

    int updateByPrimaryKeySelective(QuestionSet record);

    int updateByPrimaryKey(QuestionSet record);

    ArrayList<QuestionSet> selectByUserId(String userId);

    ArrayList<QuestionSet> deleteByQuestionSetId(String questionSetId);

    ArrayList<QuestionSet> selectByQSIdExceptQId(@Param("questionSetId") String questionSetId, @Param("questionId")String questionId);

}