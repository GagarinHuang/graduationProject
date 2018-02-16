package com.usst.service.impl.account;

import com.usst.entity.account.TUserDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("tUserDetailBE")
public class TUserDetailBE {

    public void initialize(TUserDetail tUserDetail){
        this.assignDefaults(tUserDetail);
    }

    public void assignDefaults(TUserDetail tUserDetail){
        tUserDetail.setActive(true);
        tUserDetail.setRoleId((short) 3);
    }

    public ArrayList<String> isValidForCreate(TUserDetail tUserDetail){
        ArrayList<String> msgList = new ArrayList<String>();
        //TODO:add more validation
        return msgList;
    }
}
