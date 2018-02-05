package com.usst.entity;


public class AnswerSheet {

  private long serial;
  private String examId;
  private String questionId;
  private String answer;
  private java.sql.Timestamp timestamp;
  private String invalid;
  private long questionMark;
  private String userId;


  public long getSerial() {
    return serial;
  }

  public void setSerial(long serial) {
    this.serial = serial;
  }


  public String getExamId() {
    return examId;
  }

  public void setExamId(String examId) {
    this.examId = examId;
  }


  public String getQuestionId() {
    return questionId;
  }

  public void setQuestionId(String questionId) {
    this.questionId = questionId;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }


  public java.sql.Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(java.sql.Timestamp timestamp) {
    this.timestamp = timestamp;
  }


  public String getInvalid() {
    return invalid;
  }

  public void setInvalid(String invalid) {
    this.invalid = invalid;
  }


  public long getQuestionMark() {
    return questionMark;
  }

  public void setQuestionMark(long questionMark) {
    this.questionMark = questionMark;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

}
