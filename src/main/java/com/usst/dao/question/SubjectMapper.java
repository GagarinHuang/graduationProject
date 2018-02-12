package com.usst.dao.question;

import com.usst.entity.question.Subject;

import java.util.ArrayList;

public interface SubjectMapper {
    int deleteByPrimaryKey(String subjectId);

    int insert(Subject record);

    int insertSelective(Subject record);

    Subject selectByPrimaryKey(String subjectId);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);

    ArrayList<Subject> selectAllRecords();
}