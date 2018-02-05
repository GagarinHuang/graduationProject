package com.usst.controller.account;

import com.usst.service.api.account.IUserLogin;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/userLogin")
public class UserLoginDataController {
    @Resource
    IUserLogin userLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginApi(@RequestParam(value = "userId", required = true) String userId,
                           @RequestParam(value = "userPassword",required = true) String userPassword){
        System.out.println("loginApi()");
        boolean userLogin = userLoginService.login(userId,userPassword);
        return "/index";
    }
}
