package com.usst.dao.account;

import com.usst.entity.account.Branch;

public interface BranchMapper {
    int deleteByPrimaryKey(String branchId);

    int insert(Branch record);

    int insertSelective(Branch record);

    Branch selectByPrimaryKey(String branchId);

    int updateByPrimaryKeySelective(Branch record);

    int updateByPrimaryKey(Branch record);
}