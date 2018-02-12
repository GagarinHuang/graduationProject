package com.usst.service.api.account;

import com.usst.entity.account.PUserDetail;
import com.usst.entity.account.SUserDetail;
import com.usst.entity.account.TUserDetail;
import com.usst.entity.account.UserLogin;

import java.util.ArrayList;

public interface ITUserDetail {
    public ArrayList<Object> initialize(TUserDetail tUserDetail);
    public ArrayList<String> create(TUserDetail tUserDetail, UserLogin tUserLogin);
}
