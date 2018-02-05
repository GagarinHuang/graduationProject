package com.usst.entity;


public class KnowledgePoint {

  private String knowledgePointId;
  private String knowledgePointName;
  private String tagClusterId;
  private String levelId;
  private String subjectId;
  private java.sql.Timestamp lastUpdate;


  public String getKnowledgePointId() {
    return knowledgePointId;
  }

  public void setKnowledgePointId(String knowledgePointId) {
    this.knowledgePointId = knowledgePointId;
  }


  public String getKnowledgePointName() {
    return knowledgePointName;
  }

  public void setKnowledgePointName(String knowledgePointName) {
    this.knowledgePointName = knowledgePointName;
  }


  public String getTagClusterId() {
    return tagClusterId;
  }

  public void setTagClusterId(String tagClusterId) {
    this.tagClusterId = tagClusterId;
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


  public java.sql.Timestamp getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(java.sql.Timestamp lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

}
