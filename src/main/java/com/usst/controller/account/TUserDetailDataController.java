package com.usst.controller.account;

import com.usst.entity.account.PUserDetail;
import com.usst.entity.account.SUserDetail;
import com.usst.entity.account.TUserDetail;
import com.usst.entity.account.UserLogin;
import com.usst.service.api.account.ITUserDetail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/tUserDetail")
public class TUserDetailDataController {
    @Resource
    ITUserDetail tUserDetailService;

    @RequestMapping("/initialize")
    public Map<String,Object> initializeApi(TUserDetail tUserDetail){
        System.out.println("initializeApi()");
        Map<String,Object> rmap = new HashMap<String,Object>();
        ArrayList<Object> entityList = tUserDetailService.initialize(tUserDetail);
        rmap.put("provList",entityList.get(0));
        return rmap;
    }

    @RequestMapping("/create")
    public Map<String,Object> createApi(TUserDetail tUserDetail, UserLogin tUserLogin){
        System.out.println("createApi()");
        Map<String,Object> rmap = new HashMap<String,Object>();
        ArrayList<String> msgList = this.tUserDetailService.create(tUserDetail, tUserLogin);
        rmap.put("msgList",msgList);
        return rmap;
    }

}
