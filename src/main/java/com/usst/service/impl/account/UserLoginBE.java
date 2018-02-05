package com.usst.service.impl.account;

import com.usst.dao.account.UserLoginMapper;
import com.usst.entity.account.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
            if(userPassword == userLogin.getUserPassword()) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
