package com.usst.entity;


public class QuestionSet {

  private String questionSetId;
  private String questionId;
  private long questionMark;


  public String getQuestionSetId() {
    return questionSetId;
  }

  public void setQuestionSetId(String questionSetId) {
    this.questionSetId = questionSetId;
  }


  public String getQuestionId() {
    return questionId;
  }

  public void setQuestionId(String questionId) {
    this.questionId = questionId;
  }


  public long getQuestionMark() {
    return questionMark;
  }

  public void setQuestionMark(long questionMark) {
    this.questionMark = questionMark;
  }

}
