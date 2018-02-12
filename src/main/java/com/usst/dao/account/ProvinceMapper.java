package com.usst.dao.account;

import com.usst.entity.account.Province;

import java.util.ArrayList;

public interface ProvinceMapper {
    int deleteByPrimaryKey(String provinceId);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(String provinceId);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);

    ArrayList<Province> selectAllRecords();
}