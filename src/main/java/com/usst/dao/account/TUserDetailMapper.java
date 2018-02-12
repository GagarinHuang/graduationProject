package com.usst.dao.account;

import com.usst.entity.account.TUserDetail;

public interface TUserDetailMapper {
    int deleteByPrimaryKey(String userId);

    int insert(TUserDetail record);

    int insertSelective(TUserDetail record);

    TUserDetail selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(TUserDetail record);

    int updateByPrimaryKey(TUserDetail record);
}