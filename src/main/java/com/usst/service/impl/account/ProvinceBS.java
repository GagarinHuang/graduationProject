package com.usst.service.impl.account;

import com.usst.dao.account.ProvinceMapper;
import com.usst.entity.account.Province;
import com.usst.service.api.account.IProvince;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("provinceService")
public class ProvinceBS implements IProvince{

    @Autowired
    ProvinceMapper provinceMapper;

    @Override
    public ArrayList<Province> getList() {
        return this.provinceMapper.selectAllRecords();
    }
}
