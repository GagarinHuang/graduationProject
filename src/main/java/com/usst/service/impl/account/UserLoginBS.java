package com.usst.service.impl.account;
import com.usst.dao.account.UserLoginMapper;
import com.usst.entity.account.UserLogin;
import com.usst.service.api.account.IUserLogin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.registry.infomodel.User;

@Service("userLoginService")
public class UserLoginBS implements IUserLogin {

    @Resource
    private UserLoginBE userLoginBE;

    public void setUserLoginBE(UserLoginBE userLoginBE) {
        this.userLoginBE = userLoginBE;
    }

    @Override

    public boolean login(String userId, String userPassword) {
        System.out.println("UserLoginBS-----");
        boolean result = false;
        if(userLoginBE.isValid(userId,userPassword)) {
            result = true;
        }
        return result;
    }
}
