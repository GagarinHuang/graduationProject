package com.usst.service.impl.question;

import com.usst.entity.question.Question;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

@Component("questionBE")
public class QuestionBE {
    public void initialize(Question question){
        this.assignDefaults(question);
    }
    public void assignDefaults(Question question) {
        question.setQuestionStatus((short) 0);
    }
    public ArrayList<String> isValidForCreate(Question question){
        ArrayList<String> msgList = new ArrayList<String>();
        //add more validation
        return msgList;
    }
    public ArrayList<String> isValidForUpdate(Question question) {
        ArrayList<String> msgList = new ArrayList<String>();
        //add more validation
        return msgList;
    }
    public ArrayList<String> isValidForDelete(Question question) {
        ArrayList<String> msgList = new ArrayList<String>();
        //add more validation
        return msgList;
    }

    public void changeMultipartFileToBytes (Question question) throws IOException {
        question.setAttachDescription(question.getAttachDescriptionFile().getBytes());
        question.setAttachA(question.getAttachAFile().getBytes());
        question.setAttachB(question.getAttachBFile().getBytes());
        question.setAttachC(question.getAttachCFile().getBytes());
        question.setAttachD(question.getAttachDFile().getBytes());
        question.setAttachE(question.getAttachEFile().getBytes());
        question.setAttachExplanation(question.getAttachExplanationFile().getBytes());
    }
}
