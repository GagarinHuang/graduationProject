package com.usst.service.impl.account;

import com.usst.dao.account.SUserDetailMapper;
import com.usst.entity.account.SUserDetail;
import com.usst.service.Utilities;
import com.usst.service.api.account.IProvince;
import com.usst.service.api.account.ISUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("sUserDetailService")
public class SUserDetailBS implements ISUserDetail{

    @Resource
    IProvince provinceService;


    @Resource
    SUserDetailMapper sUserDetailMapper;

    @Autowired
    SUserDetailBE sUserDetailBE;

    //private static CombineBeans<SUserDetail> combineBeans = new CombineBeans<SUserDetail>();

    @Override
    public ArrayList<String> create(SUserDetail sUserDetail) {
        SUserDetail initSUserDetail = new SUserDetail();
        this.sUserDetailBE.initialize(initSUserDetail);
        sUserDetail = (SUserDetail) Utilities.combineBeans(sUserDetail,"",initSUserDetail);
        //validation
        ArrayList<String> msgList = this.sUserDetailBE.isValidForCreate(sUserDetail);
        Utilities.setCurrentDateAndTime(sUserDetail,new String[]{"createDate"},
                                        new String[]{"yyyy-MM-dd"});
        if(msgList.isEmpty()) {
            int record = this.sUserDetailMapper.insert(sUserDetail);
            if(record <= 0){
                msgList.add("服务器创建学生信息失败");
            }
        }
        return msgList;
    }

    @Override
    public SUserDetail fetch(String userId) {

        SUserDetail sUserDetail = this.sUserDetailMapper.selectByPrimaryKey(userId);
        return  sUserDetail;
    }
}
