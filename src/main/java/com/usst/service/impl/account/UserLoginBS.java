package com.usst.service.impl.account;
import com.usst.dao.account.UserLoginMapper;
import com.usst.entity.account.PUserDetail;
import com.usst.entity.account.SUserDetail;
import com.usst.entity.account.TUserDetail;
import com.usst.entity.account.UserLogin;
import com.usst.service.api.account.IPUserDetail;
import com.usst.service.api.account.ISUserDetail;
import com.usst.service.api.account.ITUserDetail;
import com.usst.service.api.account.IUserLogin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.registry.infomodel.User;
import java.util.ArrayList;

@Service("userLoginService")
public class UserLoginBS implements IUserLogin {

    @Resource
    private UserLoginBE userLoginBE;

    @Resource
    private UserLoginMapper userLoginMapper;

    @Resource
    IPUserDetail pUserDetailService;

    @Resource
    ISUserDetail sUserDetailService;

    @Resource
    ITUserDetail tUserDetailService;

    public void setUserLoginBE(UserLoginBE userLoginBE) {
        this.userLoginBE = userLoginBE;
    }

    @Override

    public boolean login(String userId, String userPassword, HttpSession session) {
        System.out.println("UserLoginBS-----");
        boolean result = false;
        if(this.userLoginBE.isValid(userId,userPassword)) {
            result = true;
            //TODO:maybe add more attribute
            session.setAttribute("userId", userId);
        }
        return result;
    }

    public ArrayList<String> create(UserLogin userLogin) {
        ArrayList<String> msgList = this.userLoginBE.isValidForCreate(userLogin);

        if(msgList.isEmpty() ){
            int record = this.userLoginMapper.insert(userLogin);
            if(record <= 0){
                msgList.add("服务器创建帐号错误");
            }
        }
        return msgList;
    }

    @Override
    public UserLogin fetch(String userId) {
        UserLogin userLogin = this.userLoginMapper.selectByPrimaryKey(userId);
        return userLogin;
    }

    @Override
    public Short fetchRole(String userId) {
        Short roleId = 0;
        PUserDetail pUserDetail;
        SUserDetail sUserDetail;
        TUserDetail tUserDetail;
        if((pUserDetail = this.pUserDetailService.fetch(userId)) != null){
            roleId = pUserDetail.getRoleId();
        }
        else if((sUserDetail = this.sUserDetailService.fetch(userId)) != null){
            roleId = sUserDetail.getRoleId();
        }
        else if ((tUserDetail = this.tUserDetailService.fetch(userId)) != null){
            roleId = tUserDetail.getRoleId();
        }
        //add administrator
        return roleId;
    }

}
