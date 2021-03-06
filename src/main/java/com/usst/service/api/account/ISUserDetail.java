package com.usst.service.api.account;

import com.usst.entity.account.SUserDetail;
import com.usst.entity.account.UserLogin;

import java.util.ArrayList;

public interface ISUserDetail {

    public SUserDetail fetch(String userId);
    public ArrayList<String> create(SUserDetail sUserDetail);
}
