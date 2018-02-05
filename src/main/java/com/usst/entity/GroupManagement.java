package com.usst.entity;


public class GroupManagement {

  private String groupId;
  private String groupName;
  private String groupBoss;
  private String creatDate;
  private String active;
  private long number;
  private String description;
  private String announcement;
  private String affiliationId;
  private String branchId;
  private java.sql.Timestamp lastUpdate;


  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }


  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }


  public String getGroupBoss() {
    return groupBoss;
  }

  public void setGroupBoss(String groupBoss) {
    this.groupBoss = groupBoss;
  }


  public String getCreatDate() {
    return creatDate;
  }

  public void setCreatDate(String creatDate) {
    this.creatDate = creatDate;
  }


  public String getActive() {
    return active;
  }

  public void setActive(String active) {
    this.active = active;
  }


  public long getNumber() {
    return number;
  }

  public void setNumber(long number) {
    this.number = number;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getAnnouncement() {
    return announcement;
  }

  public void setAnnouncement(String announcement) {
    this.announcement = announcement;
  }


  public String getAffiliationId() {
    return affiliationId;
  }

  public void setAffiliationId(String affiliationId) {
    this.affiliationId = affiliationId;
  }


  public String getBranchId() {
    return branchId;
  }

  public void setBranchId(String branchId) {
    this.branchId = branchId;
  }


  public java.sql.Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(java.sql.Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

}
