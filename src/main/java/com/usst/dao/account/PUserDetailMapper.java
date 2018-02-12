package com.usst.dao.account;

import com.usst.entity.account.PUserDetail;

public interface PUserDetailMapper {
    int deleteByPrimaryKey(String userId);

    int insert(PUserDetail record);

    int insertSelective(PUserDetail record);

    PUserDetail selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(PUserDetail record);

    int updateByPrimaryKey(PUserDetail record);
}