package com.usst.service.impl.account;

import com.usst.dao.account.PUserDetailMapper;
import com.usst.entity.account.PUserDetail;
import com.usst.entity.account.SUserDetail;
import com.usst.entity.account.UserLogin;
import com.usst.service.Utilities;
import com.usst.service.api.account.IPUserDetail;
import com.usst.service.api.account.IProvince;
import com.usst.service.api.account.ISUserDetail;
import com.usst.service.api.account.IUserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service("PUserDetailService")
public class PUserDetailBS implements IPUserDetail {

    @Autowired
    PUserDetailBE pUserDetailBE;

    @Resource
    PUserDetailMapper pUserDetailMapper;

    @Resource
    ISUserDetail sUserDetailService;

    @Resource
    IUserLogin userLoginService;

    @Resource
    IProvince provinceService;

    //private static CombineBeans<PUserDetail> combineBeans = new CombineBeans<PUserDetail>();

    @Override
    public ArrayList<Object> initialize(PUserDetail pUserDetail) {
        ArrayList<Object> objList = new ArrayList<Object>();
        //TODO:add more initialize
        this.pUserDetailBE.initialize(pUserDetail);
        objList.add(this.provinceService.getList());
        objList.add(pUserDetail);
        return  objList;
    }

    @Transactional
    @Override
    public ArrayList<String> create(PUserDetail pUserDetail,UserLogin pUserLogin, SUserDetail sUserDetail) {
        PUserDetail initPUserDetail = new PUserDetail();
        this.pUserDetailBE.initialize(initPUserDetail);
        pUserDetail = (PUserDetail) Utilities.combineBeans(pUserDetail,"",initPUserDetail);

        ArrayList<String> msgList = this.pUserDetailBE.isValidForCreate(pUserDetail);
        Utilities.setCurrentDateAndTime(pUserDetail,new String[]{"createDate"},
                                        new String[]{"yyyy-MM-dd"});
        if(msgList.isEmpty() ){
            //创建家长账户
            msgList.addAll(this.userLoginService.create(pUserLogin));

            int record = this.pUserDetailMapper.insert(pUserDetail);
            if(record > 0){
                //创建学生账户
                UserLogin sUserLogin = new UserLogin();
                sUserLogin.setUserId("S" + pUserDetail.getMobilePhone());
                //处理下密码？6位生日
                sUserLogin.setUserPassword(sUserDetail.getDateOfBirth());
                msgList.addAll(this.userLoginService.create(sUserLogin));

                //创建学生detail信息
                sUserDetail.setUserId("S" + pUserDetail.getMobilePhone());
                msgList.addAll(this.sUserDetailService.create(sUserDetail));
            }
        }
        if(!msgList.isEmpty()) {
            msgList.add("服务器创建家长账户信息错误");
            throw new RuntimeException();
        }
        return msgList;
    }
}
