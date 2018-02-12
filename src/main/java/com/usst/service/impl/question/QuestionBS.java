package com.usst.service.impl.question;

import com.usst.dao.question.QuestionMapper;
import com.usst.entity.question.Question;
import com.usst.service.Utilities;
import com.usst.service.api.question.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;

@Service("questionService")
public class QuestionBS implements IQuestion {

    @Resource
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionBE questionBE;
    @Resource
    private ISubject subjectService;
    @Resource
    private IExamType examTypeService;
    @Resource
    private ILevel levelService;
    @Resource
    private ITextBook textBookService;

    @Override
    public ArrayList<Object> initialize(Question question) {
        ArrayList<Object> objList = new ArrayList<Object>();
        this.questionBE.initialize(question);
        //TODO:add more initialize
        objList.add(this.levelService.getList());
        objList.add(this.examTypeService.getList());
        objList.add(this.textBookService.getList());
        objList.add(this.subjectService.getList());
        objList.add(question);
        return objList;
    }

    @Override
    public Question fetch(String questionId) {

        Question question = this.questionMapper.selectByPrimaryKey(questionId);
        //resolve file type

        return  question;
    }

    @Transactional
    @Override
    public ArrayList<String> create(Question question, HttpSession session) {
        Question initQuestion = new Question();
        this.questionBE.initialize(initQuestion);
        question = (Question) Utilities.combineBeans(question,"",initQuestion);
        question.setQuestionId(Utilities.getOrderIdByUUId("q",20));
        question.setUserId((String) session.getAttribute("userId"));
        ArrayList<String> msgList = new ArrayList<String>();

        //resolve file upload
        try {
            this.questionBE.changeMultipartFileToBytes(question);
        } catch (IOException e) {
            msgList.add("文件数据转换异常");
            e.printStackTrace();
        }
        //validation
        msgList.addAll(this.questionBE.isValidForCreate(question));

        if(msgList.isEmpty()) {
            int result = this.questionMapper.insert(question);
            if(result <= 0 ){
                msgList.add("数据创建异常！");
            }
        }
        //add some related creation
        if(!msgList.isEmpty()) {
            msgList.add("服务器创建题目错误");
            throw new RuntimeException();
        }
        return msgList;
    }

    @Transactional
    @Override
    public ArrayList<String> update(Question question) {
        Question dbQuestion = this.questionMapper.selectByPrimaryKey(question.getQuestionId());
        question = (Question) Utilities.combineBeans(dbQuestion,"",question);
        ArrayList<String> msgList = new ArrayList<String>();
        Utilities.setCurrentDateAndTime(question,new String[]{"timestamp"},
                                        new String[]{"yyyy-MM-dd hh:mm:ss"});
        //resolve file upload
        try {
            this.questionBE.changeMultipartFileToBytes(question);
        } catch (IOException e) {
            msgList.add("文件数据转换异常");
            e.printStackTrace();
        }
        msgList.addAll(this.questionBE.isValidForUpdate(question));
        if(msgList.isEmpty()) {
            int result = this.questionMapper.updateByPrimaryKey(question);
            if(result <= 0) {
                msgList.add("数据更新异常！");
            }
        }
        //add some related update
        if(!msgList.isEmpty()) {
            msgList.add("服务器创建家长账户信息错误");
            throw new RuntimeException();
        }
        return msgList;
    }

    @Transactional
    @Override
    public ArrayList<String> delete(Question question) {
        ArrayList<String> msgList = this.questionBE.isValidForDelete(question);
        if(msgList.isEmpty()) {
            int result = this.questionMapper.deleteByPrimaryKey(question.getQuestionId());
            if(result <= 0) {
                msgList.add("数据删除异常！");
            }
        }
        //add some related delete
        if(!msgList.isEmpty()) {
            msgList.add("服务器创建家长账户信息错误");
            throw new RuntimeException();
        }
        return msgList;
    }

    @Override
    public ArrayList<Question> getList(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        ArrayList<Question> qList = this.questionMapper.selectAllRecordsByUserId(userId);
        return qList;
    }
}
