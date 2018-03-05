package com.usst.service.impl.question;

import com.usst.entity.question.Question;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;

@Component("questionBE")
public class QuestionBE {
    public void initialize(Question question){
        this.assignDefaults(question);
    }
    public void assignDefaults(Question question) {
        question.setQuestionStatus((short) 0);
        question.setQuestionSetId("");
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
        if(question.getAttachDescriptionFile() != null){
            question.setAttachDescription(question.getAttachDescriptionFile().getBytes());
        }
        if(question.getAttachAFile() != null){
            question.setAttachA(question.getAttachAFile().getBytes());
        }
        if(question.getAttachBFile() != null){
            question.setAttachB(question.getAttachBFile().getBytes());
        }
        if(question.getAttachCFile() != null){
            question.setAttachC(question.getAttachCFile().getBytes());
        }
        if(question.getAttachDFile() != null){
            question.setAttachD(question.getAttachDFile().getBytes());
        }
        if(question.getAttachEFile() != null){
            question.setAttachE(question.getAttachEFile().getBytes());
        }
        if(question.getAttachExplanationFile() != null){
            question.setAttachExplanation(question.getAttachExplanationFile().getBytes());
        }
    }

    public void splitItems(Question question){
        ArrayList<String> items = question.getItems();
        String[] fields = {"itemA","itemB","itemC","itemD","itemE"};
        for(int i =0;i<items.size();i++){
            try {
                Field field = question.getClass().getDeclaredField(fields[i]);
                field.setAccessible(true);
                field.set(question, items.get(i));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
