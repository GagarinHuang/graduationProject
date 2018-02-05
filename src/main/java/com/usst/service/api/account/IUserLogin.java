package com.usst.service.api.account;

public interface IUserLogin {
    /*
    * user log in to the system
    *
    * */
    boolean login(String userId, String userPassword);
}
