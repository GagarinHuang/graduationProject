package com.usst.service.impl.account;

import com.usst.entity.account.SUserDetail;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Component("sUserDetailBE")
public class SUserDetailBE {

    public void initialize(SUserDetail sUserDetail){
        this.assignDefaults(sUserDetail);
    }

    public void assignDefaults(SUserDetail sUserDetail){
        sUserDetail.setRoleId((short) 2);
    }

    public ArrayList<String> isValidForCreate(SUserDetail sUserDetail){
        ArrayList<String> msgList = new ArrayList<String>();
        //TODO:add more validation
        return msgList;
    }
}
