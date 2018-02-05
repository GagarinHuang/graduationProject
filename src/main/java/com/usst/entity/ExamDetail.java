package com.usst.entity;


public class ExamDetail {

  private String examId;
  private String examName;
  private String examTypeId;
  private String questionSetId;
  private long examStatus;
  private java.sql.Timestamp examStartTime;
  private java.sql.Timestamp examEndTime;
  private String levelId;
  private String subjectId;
  private String textbookId;
  private String examCreatorId;
  private java.sql.Timestamp createDate;
  private String description;
  private long semester;
  private String usageId;
  private String userId;
  private String mark;


  public String getExamId() {
    return examId;
  }

  public void setExamId(String examId) {
    this.examId = examId;
  }


  public String getExamName() {
    return examName;
  }

  public void setExamName(String examName) {
    this.examName = examName;
  }


  public String getExamTypeId() {
    return examTypeId;
  }

  public void setExamTypeId(String examTypeId) {
    this.examTypeId = examTypeId;
  }


  public String getQuestionSetId() {
    return questionSetId;
  }

  public void setQuestionSetId(String questionSetId) {
    this.questionSetId = questionSetId;
  }


  public long getExamStatus() {
    return examStatus;
  }

  public void setExamStatus(long examStatus) {
    this.examStatus = examStatus;
  }


  public java.sql.Timestamp getExamStartTime() {
    return examStartTime;
  }

  public void setExamStartTime(java.sql.Timestamp examStartTime) {
    this.examStartTime = examStartTime;
  }


  public java.sql.Timestamp getExamEndTime() {
    return examEndTime;
  }

  public void setExamEndTime(java.sql.Timestamp examEndTime) {
    this.examEndTime = examEndTime;
  }


  public String getLevelId() {
    return levelId;
  }

  public void setLevelId(String levelId) {
    this.levelId = levelId;
  }


  public String getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(String subjectId) {
    this.subjectId = subjectId;
  }


  public String getTextbookId() {
    return textbookId;
  }

  public void setTextbookId(String textbookId) {
    this.textbookId = textbookId;
  }


  public String getExamCreatorId() {
    return examCreatorId;
  }

  public void setExamCreatorId(String examCreatorId) {
    this.examCreatorId = examCreatorId;
  }


  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Timestamp createDate) {
    this.createDate = createDate;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getSemester() {
    return semester;
  }

  public void setSemester(long semester) {
    this.semester = semester;
  }


  public String getUsageId() {
    return usageId;
  }

  public void setUsageId(String usageId) {
    this.usageId = usageId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

}
