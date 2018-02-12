package com.usst.entity.question;

import java.util.Date;

public class KnowledgePoint {
    private String knowledgePointId;

    private String knowledgePointName;

    private String tagClusterId;

    private String levelId;

    private String subjectId;

    private Date lastUpdate;

    public String getKnowledgePointId() {
        return knowledgePointId;
    }

    public void setKnowledgePointId(String knowledgePointId) {
        this.knowledgePointId = knowledgePointId == null ? null : knowledgePointId.trim();
    }

    public String getKnowledgePointName() {
        return knowledgePointName;
    }

    public void setKnowledgePointName(String knowledgePointName) {
        this.knowledgePointName = knowledgePointName == null ? null : knowledgePointName.trim();
    }

    public String getTagClusterId() {
        return tagClusterId;
    }

    public void setTagClusterId(String tagClusterId) {
        this.tagClusterId = tagClusterId == null ? null : tagClusterId.trim();
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId == null ? null : levelId.trim();
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId == null ? null : subjectId.trim();
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}