package com.usst.entity;


public class UserLogin {

  private String userId;
  private String userPassword;
  private String nickName;
  private String mobilePhone;
  private String e_Mail;


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public String getNickName() {
    return nickName;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }


  public String getMobilePhone() {
    return mobilePhone;
  }

  public void setMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
  }


  public String getE_Mail() {
    return e_Mail;
  }

  public void setE_Mail(String e_Mail) {
    this.e_Mail = e_Mail;
  }

}
