package com.usst.service.impl.account;

import com.usst.dao.account.UserLoginMapper;
import com.usst.entity.account.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("userLoginBE")
public class UserLoginBE {

    @Autowired
    private UserLoginMapper userLoginMapper;

    public boolean isValid(String userId, String userPassword){
        UserLogin userLogin = userLoginMapper.selectByPrimaryKey(userId);
        if(userLogin == null) {
            return false;
        }
        else {
            if(userPassword.equals(userLogin.getUserPassword())) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    public ArrayList<String> isValidForCreate(UserLogin userLogin){
        ArrayList<String> msgList = new ArrayList<String>();
        //TODO:add more validation
        return msgList;
    }
}
