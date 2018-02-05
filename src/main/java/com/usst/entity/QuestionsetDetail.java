package com.usst.entity;


public class QuestionsetDetail {

  private String questionsetSetId;
  private String questionSetName;
  private String levelId;
  private String subjectId;
  private String textbookId;
  private String editorId;
  private java.sql.Timestamp createdate;
  private String description;
  private String examTypeId;


  public String getQuestionsetSetId() {
    return questionsetSetId;
  }

  public void setQuestionsetSetId(String questionsetSetId) {
    this.questionsetSetId = questionsetSetId;
  }


  public String getQuestionSetName() {
    return questionSetName;
  }

  public void setQuestionSetName(String questionSetName) {
    this.questionSetName = questionSetName;
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


  public String getEditorId() {
    return editorId;
  }

  public void setEditorId(String editorId) {
    this.editorId = editorId;
  }


  public java.sql.Timestamp getCreatedate() {
    return createdate;
  }

  public void setCreatedate(java.sql.Timestamp createdate) {
    this.createdate = createdate;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getExamTypeId() {
    return examTypeId;
  }

  public void setExamTypeId(String examTypeId) {
    this.examTypeId = examTypeId;
  }

}
