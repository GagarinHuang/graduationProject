package com.usst.dao.account;

import com.usst.entity.account.QuestionSet;
import com.usst.entity.account.QuestionSetKey;

public interface QuestionSetMapper {
    int deleteByPrimaryKey(QuestionSetKey key);

    int insert(QuestionSet record);

    int insertSelective(QuestionSet record);

    QuestionSet selectByPrimaryKey(QuestionSetKey key);

    int updateByPrimaryKeySelective(QuestionSet record);

    int updateByPrimaryKey(QuestionSet record);
}