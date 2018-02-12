package com.usst.entity.question;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class Question {
    /*题目id*/
    private String questionId;
    /*阶段id*/
    private String levelId;
    /*知识领域（学科）id*/
    private String subjectId;
    /*对应考试id*/
    private String examTpyeId;
    /*教科书id*/
    private String textbookId;
    /*知识点id*/
    private String knowledgePointId;
    /*学期*/
    private Short semester;
    /*模块*/
    private Short module;
    /*章节*/
    private Short chapter;
    /*单元*/
    private Short unit;
    /*题目主体*/
    private String description;
    /*题目主题附件*/
    private byte[] attachDescription;

    private MultipartFile attachDescriptionFile;

    /*A选项*/
    private String itemA;

    private String itemB;

    private String itemC;

    private String itemD;

    private String itemE;
    /*答案*/
    private String answer;
    /*选项A附件*/
    private byte[] attachA;

    private MultipartFile attachAFile;

    private byte[] attachB;

    private MultipartFile attachBFile;

    private byte[] attachC;

    private MultipartFile attachCFile;

    private byte[] attachD;

    private MultipartFile attachDFile;

    private byte[] attachE;

    private MultipartFile attachEFile;

    /*解析*/
    private String explanation;
    /*解析附件*/
    private byte[] attachExplanation;

    private MultipartFile attachExplanationFile;

    /*0:未提交
    * 1:提交并且审核通过
    * 2:提交并且审核未通过
    * 3：提交审核中
    * */
    private Short questionStatus;
    /*题型
    * */
    private Short questionType;
    /*题目归属id*/
    private String questionSetId;

    private String branchId;
    /*用户id*/
    private String userId;
    /*创建时间*/
    private Date timestamp;
    /*分值*/
    private Integer grade;
    /*评论*/
    private String comment;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId == null ? null : questionId.trim();
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

    public String getExamTpyeId() {
        return examTpyeId;
    }

    public void setExamTpyeId(String examTpyeId) {
        this.examTpyeId = examTpyeId == null ? null : examTpyeId.trim();
    }

    public String getTextbookId() {
        return textbookId;
    }

    public void setTextbookId(String textbookId) {
        this.textbookId = textbookId == null ? null : textbookId.trim();
    }

    public String getKnowledgePointId() {
        return knowledgePointId;
    }

    public void setKnowledgePointId(String knowledgePointId) {
        this.knowledgePointId = knowledgePointId == null ? null : knowledgePointId.trim();
    }

    public Short getSemester() {
        return semester;
    }

    public void setSemester(Short semester) {
        this.semester = semester;
    }

    public Short getModule() {
        return module;
    }

    public void setModule(Short module) {
        this.module = module;
    }

    public Short getChapter() {
        return chapter;
    }

    public void setChapter(Short chapter) {
        this.chapter = chapter;
    }

    public Short getUnit() {
        return unit;
    }

    public void setUnit(Short unit) {
        this.unit = unit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public byte[] getAttachDescription() {
        return attachDescription;
    }

    public void setAttachDescription(byte[] attachDescription) {
        this.attachDescription = attachDescription;
    }

    public String getItemA() {
        return itemA;
    }

    public void setItemA(String itemA) {
        this.itemA = itemA == null ? null : itemA.trim();
    }

    public String getItemB() {
        return itemB;
    }

    public void setItemB(String itemB) {
        this.itemB = itemB == null ? null : itemB.trim();
    }

    public String getItemC() {
        return itemC;
    }

    public void setItemC(String itemC) {
        this.itemC = itemC == null ? null : itemC.trim();
    }

    public String getItemD() {
        return itemD;
    }

    public void setItemD(String itemD) {
        this.itemD = itemD == null ? null : itemD.trim();
    }

    public String getItemE() {
        return itemE;
    }

    public void setItemE(String itemE) {
        this.itemE = itemE == null ? null : itemE.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public byte[] getAttachA() {
        return attachA;
    }

    public void setAttachA(byte[] attachA) {
        this.attachA = attachA;
    }

    public byte[] getAttachB() {
        return attachB;
    }

    public void setAttachB(byte[] attachB) {
        this.attachB = attachB;
    }

    public byte[] getAttachC() {
        return attachC;
    }

    public void setAttachC(byte[] attachC) {
        this.attachC = attachC;
    }

    public byte[] getAttachD() {
        return attachD;
    }

    public void setAttachD(byte[] attachD) {
        this.attachD = attachD;
    }

    public byte[] getAttachE() {
        return attachE;
    }

    public void setAttachE(byte[] attachE) {
        this.attachE = attachE;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation == null ? null : explanation.trim();
    }

    public byte[] getAttachExplanation() {
        return attachExplanation;
    }

    public void setAttachExplanation(byte[] attachExplanation) {
        this.attachExplanation = attachExplanation;
    }

    public Short getQuestionStatus() {
        return questionStatus;
    }

    public void setQuestionStatus(Short questionStatus) {
        this.questionStatus = questionStatus;
    }

    public Short getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Short questionType) {
        this.questionType = questionType;
    }

    public String getQuestionSetId() {
        return questionSetId;
    }

    public void setQuestionSetId(String questionSetId) {
        this.questionSetId = questionSetId == null ? null : questionSetId.trim();
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId == null ? null : branchId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public MultipartFile getAttachDescriptionFile() {
        return attachDescriptionFile;
    }

    public void setAttachDescriptionFile(MultipartFile attachDescriptionFile) {
        this.attachDescriptionFile = attachDescriptionFile;
    }

    public MultipartFile getAttachAFile() {
        return attachAFile;
    }

    public void setAttachAFile(MultipartFile attachAFile) {
        this.attachAFile = attachAFile;
    }

    public MultipartFile getAttachBFile() {
        return attachBFile;
    }

    public void setAttachBFile(MultipartFile attachBFile) {
        this.attachBFile = attachBFile;
    }

    public MultipartFile getAttachCFile() {
        return attachCFile;
    }

    public void setAttachCFile(MultipartFile attachCFile) {
        this.attachCFile = attachCFile;
    }

    public MultipartFile getAttachDFile() {
        return attachDFile;
    }

    public void setAttachDFile(MultipartFile attachDFile) {
        this.attachDFile = attachDFile;
    }

    public MultipartFile getAttachEFile() {
        return attachEFile;
    }

    public void setAttachEFile(MultipartFile attachEFile) {
        this.attachEFile = attachEFile;
    }

    public MultipartFile getAttachExplanationFile() {
        return attachExplanationFile;
    }

    public void setAttachExplanationFile(MultipartFile attachExplanationFile) {
        this.attachExplanationFile = attachExplanationFile;
    }
}