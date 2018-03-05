package com.usst.service.api.question;

import java.util.ArrayList;
import com.usst.entity.question.QuestionsetDetail;

import javax.servlet.http.HttpSession;

public interface IQuestionSetDetail {

    public ArrayList<Object> initialize(QuestionsetDetail questionSetDetail);
    public QuestionsetDetail fetch(String questionSetId);
    public ArrayList<String> create(QuestionsetDetail record);
    public ArrayList<String> update(QuestionsetDetail record);
    public ArrayList<String> delete(QuestionsetDetail questionSetDetail);
    public ArrayList<QuestionsetDetail> getList(HttpSession session);
}
