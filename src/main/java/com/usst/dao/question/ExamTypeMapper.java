package com.usst.dao.question;

import com.usst.entity.question.ExamType;

import java.util.ArrayList;

public interface ExamTypeMapper {
    int deleteByPrimaryKey(String examTypeId);

    int insert(ExamType record);

    int insertSelective(ExamType record);

    ExamType selectByPrimaryKey(String examTypeId);

    int updateByPrimaryKeySelective(ExamType record);

    int updateByPrimaryKey(ExamType record);

    ArrayList<ExamType> selectAllRecords();
}