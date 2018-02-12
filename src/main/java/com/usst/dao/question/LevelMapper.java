package com.usst.dao.question;

import com.usst.entity.question.Level;

import java.util.ArrayList;

public interface LevelMapper {
    int deleteByPrimaryKey(String levelId);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(String levelId);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);

    ArrayList<Level> selectAllRecords();
}