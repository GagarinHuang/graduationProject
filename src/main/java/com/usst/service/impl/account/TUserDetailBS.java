package com.usst.service.impl.account;

import com.usst.dao.account.TUserDetailMapper;
import com.usst.entity.account.TUserDetail;
import com.usst.entity.account.UserLogin;
import com.usst.service.Utilities;
import com.usst.service.api.account.IProvince;
import com.usst.service.api.account.ITUserDetail;
import com.usst.service.api.account.IUserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service("TUserDetailService")
public class TUserDetailBS implements ITUserDetail {

    @Autowired
    TUserDetailBE tUserDetailBE;

    @Resource
    IProvince provinceService;

    @Resource
    IUserLogin userLoginService;

    @Resource
    TUserDetailMapper tUserDetailMapper;

    @Override
    public ArrayList<Object> initialize(TUserDetail tUserDetail) {
        ArrayList<Object> objList = new ArrayList<Object>();
        //TODO:add more initialize
        this.tUserDetailBE.initialize(tUserDetail);
        objList.add(this.provinceService.getList());
        objList.add(tUserDetail);
        return  objList;
    }


    @Transactional
    @Override
    public ArrayList<String> create(TUserDetail tUserDetail, UserLogin tUserLogin) {
        TUserDetail initTUserDetail = new TUserDetail();
        this.tUserDetailBE.initialize(initTUserDetail);
        tUserDetail = (TUserDetail) Utilities.combineBeans(tUserDetail,"",initTUserDetail);
        //validation
        ArrayList<String> msgList = this.tUserDetailBE.isValidForCreate(tUserDetail);
        tUserDetail.setUserId(tUserLogin.getUserId());
        tUserDetail.setMobilePhone(tUserLogin.getUserId());
        Utilities.setCurrentDateAndTime(tUserDetail,new String[]{"createDate"},
                                        new String[]{"yyyy-MM-dd"});
        try {
            if(msgList.isEmpty() ){
                //创建家长账户
                msgList.addAll(this.userLoginService.create(tUserLogin));
                int record = this.tUserDetailMapper.insert(tUserDetail);
                if(record <= 0){
                    msgList.add("数据库插入家长信息错误");
                }
            }
            if(!msgList.isEmpty()) {
                msgList.add("服务器创建老师账户信息错误");
                throw new RuntimeException();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            msgList.add("服务器异常");
            throw new RuntimeException();
        }
        finally {
            return msgList;
        }
    }

    @Override
    public TUserDetail fetch(String userId) {

        TUserDetail tUserDetail = this.tUserDetailMapper.selectByPrimaryKey(userId);
        return  tUserDetail;
    }
}
