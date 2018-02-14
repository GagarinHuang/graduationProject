package com.usst.dao.account;

import com.usst.entity.account.Municipality;

import java.util.ArrayList;

public interface MunicipalityMapper {
    int deleteByPrimaryKey(String municipalityId);

    int insert(Municipality record);

    int insertSelective(Municipality record);

    Municipality selectByPrimaryKey(String municipalityId);

    int updateByPrimaryKeySelective(Municipality record);

    int updateByPrimaryKey(Municipality record);

    ArrayList<Municipality> selectAllRecords();
}