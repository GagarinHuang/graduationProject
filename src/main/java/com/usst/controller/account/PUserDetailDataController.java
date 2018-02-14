package com.usst.controller.account;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usst.entity.account.PUserDetail;
import com.usst.entity.account.SUserDetail;
import com.usst.entity.account.UserLogin;
import com.usst.service.api.account.IPUserDetail;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> createApi(@RequestParam(value = "json",required = false) String json){
        System.out.println("createApi()");
        System.out.println(json);
        Map<String,Object> rmap = new HashMap<String,Object>();
        JSONObject jsonObj = JSONObject.fromObject(json);
        //p user detail
        JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getJSONObject("pUserDetail"));
        PUserDetail pUserDetail = new PUserDetail();
        pUserDetail = (PUserDetail) JSONObject.toBean(jsonObj1, pUserDetail.getClass());
        //p user login
        JSONObject jsonObj2 = JSONObject.fromObject(jsonObj.getJSONObject("pUserLogin"));
        UserLogin pUserLogin = new UserLogin();
        pUserLogin = (UserLogin) JSONObject.toBean(jsonObj2, pUserLogin.getClass());
        //s user detail
        JSONObject jsonObj3 = JSONObject.fromObject(jsonObj.getJSONObject("sUserDetail"));
        SUserDetail sUserDetail = new SUserDetail();
        sUserDetail = (SUserDetail) JSONObject.toBean(jsonObj3, sUserDetail.getClass());
        ArrayList<String> msgList = this.pUserDetailService.create(pUserDetail, pUserLogin, sUserDetail);
        rmap.put("msgList",msgList);
        UserLogin sUserLogin = new UserLogin();
        if(msgList.isEmpty()){
            sUserLogin.setUserId(sUserDetail.getUserId());
            sUserLogin.setUserPassword(sUserDetail.getDateOfBirth());
            rmap.put("sUserLogin",sUserLogin);
        }
        return rmap;
    }


}
