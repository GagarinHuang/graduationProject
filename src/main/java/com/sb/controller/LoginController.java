package com.sb.controller;

import com.sb.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
public class LoginController {
    @Autowired
    private ILoginService loginService;
    @RequestMapping("/index")
    public String goToLogin(){
        System.out.println("a");
        return "/login";
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("b");
        System.out.println(request.getSession());
        Map<String ,Object> m=new HashMap<String, Object>();
        List< Map<String ,Object>> list=loginService.getList(m);
        try {
            response.getWriter().print(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
