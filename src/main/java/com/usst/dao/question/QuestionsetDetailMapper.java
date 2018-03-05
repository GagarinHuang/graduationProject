package com.usst.dao.question;

import com.usst.entity.question.QuestionsetDetail;

public interface QuestionsetDetailMapper {
    int deleteByPrimaryKey(String questionsetSetId);

    int insert(QuestionsetDetail record);

    int insertSelective(QuestionsetDetail record);

    QuestionsetDetail selectByPrimaryKey(String questionsetSetId);

    int updateByPrimaryKeySelective(QuestionsetDetail record);

    int updateByPrimaryKeyWithBLOBs(QuestionsetDetail record);

    int updateByPrimaryKey(QuestionsetDetail record);
}