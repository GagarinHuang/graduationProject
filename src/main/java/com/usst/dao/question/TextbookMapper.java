package com.usst.dao.question;

import com.usst.entity.question.Textbook;

import java.util.ArrayList;

public interface TextbookMapper {
    int deleteByPrimaryKey(String textBookId);

    int insert(Textbook record);

    int insertSelective(Textbook record);

    Textbook selectByPrimaryKey(String textBookId);

    int updateByPrimaryKeySelective(Textbook record);

    int updateByPrimaryKey(Textbook record);

    ArrayList<Textbook> selectAllRecords();
}