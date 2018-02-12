package com.usst.dao.question;

import com.usst.entity.question.KnowledgePoint;

public interface KnowledgePointMapper {
    int deleteByPrimaryKey(String knowledgePointId);

    int insert(KnowledgePoint record);

    int insertSelective(KnowledgePoint record);

    KnowledgePoint selectByPrimaryKey(String knowledgePointId);

    int updateByPrimaryKeySelective(KnowledgePoint record);

    int updateByPrimaryKey(KnowledgePoint record);
}