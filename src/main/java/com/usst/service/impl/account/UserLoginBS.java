package com.usst.service.impl.account;
import com.usst.dao.account.UserLoginMapper;
import com.usst.entity.account.UserLogin;
import com.usst.service.api.account.IUserLogin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.registry.infomodel.User;

@Service("loginService")
public class UserLoginBS implements IUserLogin {

    @Resource
    private UserLoginMapper userLoginMapper;

    @Override
    public boolean login(String userId, String userPassword) {
        System.out.println("UserLoginBS-----");
        userId = "test";
        UserLogin userInfo = (UserLogin) userLoginMapper.selectByPrimaryKey(userId);
        System.out.println(userInfo.getUserPassword());
        return false;
    }
}
