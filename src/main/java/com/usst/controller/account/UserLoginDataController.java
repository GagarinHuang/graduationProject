package com.usst.controller.account;

import com.usst.entity.account.UserLogin;
import com.usst.service.api.account.IUserLogin;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/userLogin")
public class UserLoginDataController {
    @Resource
    IUserLogin userLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Boolean> loginApi(@RequestBody UserLogin userLogin,HttpSession session){
        System.out.println("loginApi()");
        Map<String,Boolean> rmap = new HashMap<String,Boolean>();
        boolean result = userLoginService.login(userLogin.getUserId(),userLogin.getUserPassword(),session);
        rmap.put("result",result);
        return rmap;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session, HttpServletRequest request){
        if(session!=null)
        {
            System.out.println("清除此次会话");
            session.invalidate();
        }
        System.out.println("退出！");
        //return new ModelAndView("redirect:"+request.getContextPath()+"jsp/index");
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/handleFieldChange", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> handleFieldChange(
            @RequestParam(value = "fieldName",required = false) String fieldName,
            @RequestParam(value = "fieldValue",required = false) String fieldValue){
        System.out.println("handleFieldChange(" + fieldName + ","+ fieldValue +")");
        Map<String, String> rmap = new HashMap<String, String>();
        if(fieldName.equals("userId")){
            UserLogin userLogin = this.userLoginService.fetch(fieldValue);
            if(userLogin != null){
                rmap.put("msg","用户已存在");
            }
            else {
                rmap.put("msg","");
            }
        }
        else {
            rmap.put("msg","");
        }
        return rmap;
    }

}
