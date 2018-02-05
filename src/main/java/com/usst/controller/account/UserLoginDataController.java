package com.usst.controller.account;

import com.usst.entity.account.UserLogin;
import com.usst.service.api.account.IUserLogin;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/userLogin")
public class UserLoginDataController {
    @Resource
    IUserLogin userLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Boolean> loginApi(@RequestBody UserLogin userLogin){
        System.out.println("loginApi()");
        Map<String,Boolean> rmap = new HashMap<String,Boolean>();
        boolean result = userLoginService.login(userLogin.getUserId(),userLogin.getUserPassword());
        rmap.put("result",result);
        return rmap;
    }
}
