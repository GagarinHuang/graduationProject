package com.usst.service.api.account;

import com.usst.entity.account.UserLogin;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public interface IUserLogin {
    /*
    * user log in to the system
    *
    * */
    boolean login(String userId, String userPassword, HttpSession session);

    ArrayList<String> create(UserLogin userLogin);

    UserLogin fetch(String userId);
}
