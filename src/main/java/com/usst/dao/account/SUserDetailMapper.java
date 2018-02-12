package com.usst.dao.account;

import com.usst.entity.account.SUserDetail;

public interface SUserDetailMapper {
    int deleteByPrimaryKey(String userId);

    int insert(SUserDetail record);

    int insertSelective(SUserDetail record);

    SUserDetail selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(SUserDetail record);

    int updateByPrimaryKey(SUserDetail record);
}