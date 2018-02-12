package com.usst.dao.account;

import com.usst.entity.account.Affiliation;

public interface AffiliationMapper {
    int deleteByPrimaryKey(String affiliationId);

    int insert(Affiliation record);

    int insertSelective(Affiliation record);

    Affiliation selectByPrimaryKey(String affiliationId);

    int updateByPrimaryKeySelective(Affiliation record);

    int updateByPrimaryKey(Affiliation record);
}