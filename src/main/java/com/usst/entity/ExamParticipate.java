package com.usst.entity;


public class ExamParticipate {

  private long serial;
  private String questionSetId;
  private String groupId;
  private java.sql.Timestamp timestamp;
  private String status;


  public long getSerial() {
    return serial;
  }

  public void setSerial(long serial) {
    this.serial = serial;
  }


  public String getQuestionSetId() {
    return questionSetId;
  }

  public void setQuestionSetId(String questionSetId) {
    this.questionSetId = questionSetId;
  }


  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }


  public java.sql.Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(java.sql.Timestamp timestamp) {
    this.timestamp = timestamp;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}
