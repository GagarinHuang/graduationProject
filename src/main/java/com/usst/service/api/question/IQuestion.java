package com.usst.service.api.question;

import com.usst.entity.question.Question;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

public interface IQuestion {
    public ArrayList<Object> initialize(Question question);
    public Question fetch(String questionId);
    public ArrayList<String> create(Question record, HttpSession session);
    public ArrayList<String> update(Question record);
    public ArrayList<String> delete(Question question);
    public ArrayList<Question> getList(HttpSession session);
}
