package com.usst.controller.account;

import com.usst.entity.account.PUserDetail;
import com.usst.entity.account.SUserDetail;
import com.usst.entity.account.UserLogin;
import com.usst.service.api.account.IPUserDetail;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/pUserDetail")
public class PUserDetailDataController {
    @Resource
    IPUserDetail pUserDetailService;

    //TODO:ModelAndView?
    @RequestMapping("/initialize")
    public Map<String,Object> initializeApi(PUserDetail pUserDetail){
        System.out.println("initializeApi()");
        Map<String,Object> rmap = new HashMap<String,Object>();
        ArrayList<Object> entityList = pUserDetailService.initialize(pUserDetail);
        rmap.put("provList",entityList.get(0));
        return rmap;
    }

    @RequestMapping("/create")
    public Map<String,Object> createApi(PUserDetail pUserDetail, UserLogin pUserLogin, SUserDetail sUserDetail){
        System.out.println("createApi()");
        Map<String,Object> rmap = new HashMap<String,Object>();
        ArrayList<String> msgList = this.pUserDetailService.create(pUserDetail, pUserLogin, sUserDetail);
        rmap.put("msgList",msgList);
        return rmap;
    }


}
