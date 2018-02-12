package com.usst.entity.question;

public class ExamType {
    private String examTypeId;

    private String examTypeName;

    public String getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(String examTypeId) {
        this.examTypeId = examTypeId == null ? null : examTypeId.trim();
    }

    public String getExamTypeName() {
        return examTypeName;
    }

    public void setExamTypeName(String examTypeName) {
        this.examTypeName = examTypeName == null ? null : examTypeName.trim();
    }
}