package com.usst.entity;


public class Exam {

  private long examId;
  private String examName;
  private String questionSetId;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private long limitTime;
  private String note;
  private String status;
  private java.sql.Timestamp timestamp;
  private String type;


  public long getExamId() {
    return examId;
  }

  public void setExamId(long examId) {
    this.examId = examId;
  }


  public String getExamName() {
    return examName;
  }

  public void setExamName(String examName) {
    this.examName = examName;
  }


  public String getQuestionSetId() {
    return questionSetId;
  }

  public void setQuestionSetId(String questionSetId) {
    this.questionSetId = questionSetId;
  }


  public java.sql.Timestamp getStartTime() {
    return startTime;
  }

  public void setStartTime(java.sql.Timestamp startTime) {
    this.startTime = startTime;
  }


  public java.sql.Timestamp getEndTime() {
    return endTime;
  }

  public void setEndTime(java.sql.Timestamp endTime) {
    this.endTime = endTime;
  }


  public long getLimitTime() {
    return limitTime;
  }

  public void setLimitTime(long limitTime) {
    this.limitTime = limitTime;
  }


  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public java.sql.Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(java.sql.Timestamp timestamp) {
    this.timestamp = timestamp;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
