package com.usst.service.impl.account;

import com.usst.entity.account.PUserDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("PUserDetailBE")
public class PUserDetailBE {

    public void initialize(PUserDetail pUserDetail) {
        this.assignDefault(pUserDetail);
        //add more
    }

    public void assignDefault(PUserDetail pUserDetail) {
        pUserDetail.setRoleId((short) 1);
    }

    public ArrayList<String> isValidForCreate(PUserDetail pUserDetail){
        ArrayList<String> msgList = new ArrayList<String>();
        //TODO:add more validation
        return msgList;
    }
}
