package com.usst.controller.account;

import com.usst.entity.account.PUserDetail;
import com.usst.entity.account.SUserDetail;
import com.usst.entity.account.TUserDetail;
import com.usst.entity.account.UserLogin;
import com.usst.service.api.account.ITUserDetail;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public Map<String,Object> createApi(@RequestParam(value = "json",required = false) String json){
        System.out.println("createApi()");
        System.out.println("json:"+json);
        Map<String,Object> rmap = new HashMap<String,Object>();
        JSONObject jsonObj = JSONObject.fromObject(json);
        //t user detail
        JSONObject jsonObj1 = JSONObject.fromObject(jsonObj.getJSONObject("tUserDetail"));
        TUserDetail tUserDetail = new TUserDetail();
        tUserDetail = (TUserDetail) JSONObject.toBean(jsonObj1, tUserDetail.getClass());
        //t user login
        JSONObject jsonObj2 = JSONObject.fromObject(jsonObj.getJSONObject("tUserLogin"));
        UserLogin tUserLogin = new UserLogin();
        tUserLogin = (UserLogin) JSONObject.toBean(jsonObj2, tUserLogin.getClass());
        //call t user detail service
        ArrayList<String> msgList = this.tUserDetailService.create(tUserDetail, tUserLogin);
        rmap.put("msgList",msgList);
        return rmap;
    }

}
