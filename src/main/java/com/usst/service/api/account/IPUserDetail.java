package com.usst.service.api.account;

import com.usst.entity.account.PUserDetail;
import com.usst.entity.account.SUserDetail;
import com.usst.entity.account.UserLogin;

import java.util.ArrayList;

public interface IPUserDetail {

    public ArrayList<Object> initialize(PUserDetail pUserDetail);
    public ArrayList<String> create(PUserDetail pUserDetail, UserLogin pUserLogin, SUserDetail sUserDetail);
}
