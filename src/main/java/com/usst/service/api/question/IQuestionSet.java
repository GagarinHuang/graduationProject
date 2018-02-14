package com.usst.service.api.question;

import com.usst.entity.account.QuestionSet;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public interface IQuestionSet {

    public ArrayList<Object> initialize(QuestionSet questionSet);
    public QuestionSet fetch(String questionSetId);
    public ArrayList<String> create(QuestionSet record, HttpSession session);
    public ArrayList<String> update(QuestionSet record);
    public ArrayList<String> delete(QuestionSet questionSet);
    public ArrayList<QuestionSet> getList(HttpSession session);
}
