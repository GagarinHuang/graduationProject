package com.usst.entity.question;

import java.util.ArrayList;
import java.util.Date;

public class QuestionSet extends QuestionSetKey {

    //为了前台json树型结构
    private String id;

    private Integer questionMark;

    //不用。用description
    private String questionSetName;

    private String levelId;

    private String subjectId;

    private String textbookId;

    private String editorId;

    private Date createdate;

    private String examTypeId;

    private String description;

    private ArrayList<Question> children;

    public Integer getQuestionMark() {
        return questionMark;
    }

    public void setQuestionMark(Integer questionMark) {
        this.questionMark = questionMark;
    }

    public ArrayList<Question> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Question> children) {
        this.children = children;
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

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getExamTypeId() {
        return examTypeId;
    }

    public void setExamTypeId(String examTypeId) {
        this.examTypeId = examTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QuestionSet() {
    }
}