package com.usst.service.impl.question;

import com.usst.dao.question.QuestionMapper;
import com.usst.dao.question.QuestionSetMapper;
import com.usst.dao.question.QuestionsetDetailMapper;
import com.usst.entity.question.Question;
import com.usst.entity.question.QuestionSet;
import com.usst.entity.question.QuestionSetKey;
import com.usst.entity.question.QuestionsetDetail;
import com.usst.service.Utilities;
import com.usst.service.api.question.IQuestionSet;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;

@Service("QuestionSetService")
public class QuestionSetBS implements IQuestionSet {

    @Resource
    private QuestionSetMapper questionSetMapper;

    @Resource
    private QuestionMapper questionMapper;

    @Resource
    private QuestionsetDetailMapper questionsetDetailMapper;

    @Override
    public ArrayList<Object> initialize(QuestionSet questionSet) {
        return null;
    }

    @Override
    public QuestionSet fetch(String questionSetId) {
        return null;
    }

    @Override
    @Transactional
    public ArrayList<String> group(ArrayList<String> qsIds,
                                    ArrayList<String> qIds,
                                    HttpSession session) {
        ArrayList<String> msgList = new ArrayList<String>();
        Iterator<String> itorQS = qsIds.iterator();
        Iterator<String> itorQ = qIds.iterator();
        try {
            //新建qs_detail
            String newQSId = Utilities.getOrderIdByUUId("qs",19);
            QuestionsetDetail questionsetDetail = new QuestionsetDetail();
            //应该传具体qs bean？
            questionsetDetail.setQuestionsetSetId(newQSId);
            questionsetDetail.setQuestionSetName("newQS");
            questionsetDetail.setDescription("newQS");
            questionsetDetail.setExamTypeId("1");
            Utilities.setCurrentDateAndTime(questionsetDetail,new String[]{"createdate"},
                    new String[]{"YYYY-MM-DD HH:MM:SS"});
            this.questionsetDetailMapper.insert(questionsetDetail);
            while(itorQ.hasNext()){
                String qId = itorQ.next();
                //获取之前的qsId,删除question_set表中的记录
                Question question = this.questionMapper.selectByPrimaryKey(qId);
                String qsId = question.getQuestionSetId();
                System.out.println(qsId);
                QuestionSetKey qsk = new QuestionSetKey();
                qsk.setQuestionId(qId);
                qsk.setQuestionSetId(qsId);
                ArrayList<QuestionSet> qs = this.questionSetMapper.selectByQSIdExceptQId(qsId,qId);
                if(qs.isEmpty()){
                    //如果这个group不存在其他q，删掉这个qs
                    this.questionsetDetailMapper.deleteByPrimaryKey(qsId);
                }
                this.questionSetMapper.deleteByPrimaryKey(qsk);
                //更新q
                this.questionMapper.updateQSIdByPrimaryKey(newQSId,qId);
                //新建qs,q 关系
                QuestionSet questionSet = new QuestionSet();
                questionSet.setQuestionSetId(newQSId);
                questionSet.setQuestionId(qId);
                questionSet.setQuestionMark(question.getGrade());
                this.questionSetMapper.insert(questionSet);

            }
        }
        catch (Exception e){
            e.printStackTrace();
            msgList.add("Server error!");
            throw new RuntimeException();
        }
        finally {
            return msgList;
        }
    }

    @Override
    @Transactional
    public ArrayList<String> ungroup(ArrayList<String> qsIds,
                                   ArrayList<String> qIds,
                                   HttpSession session) {
        ArrayList<String> msgList = new ArrayList<String>();
        Iterator<String> itorQS = qsIds.iterator();
        Iterator<String> itorQ = qIds.iterator();
        String newQSId = "Ungroup";
        try {
            QuestionsetDetail originQS = this.questionsetDetailMapper.selectByPrimaryKey(newQSId);
            if(originQS == null ){
                //新建qs_detail:Ungroup
                QuestionsetDetail questionsetDetail = new QuestionsetDetail();
                //应该传具体qs bean？
                questionsetDetail.setQuestionsetSetId(newQSId);
                questionsetDetail.setQuestionSetName(newQSId);
                questionsetDetail.setDescription(newQSId);
                questionsetDetail.setExamTypeId("1");
                Utilities.setCurrentDateAndTime(questionsetDetail,new String[]{"createdate"},
                        new String[]{"YYYY-MM-DD HH:MM:SS"});
                this.questionsetDetailMapper.insert(questionsetDetail);
            }
            while(itorQ.hasNext()){
                String qId = itorQ.next();
                System.out.println("qId: "+ qId);
                //获取之前的qsId,删除question_set表中的记录
                Question question = this.questionMapper.selectByPrimaryKey(qId);
                String qsId = question.getQuestionSetId();
                System.out.println(qsId);
                QuestionSetKey qsk = new QuestionSetKey();
                qsk.setQuestionId(qId);
                qsk.setQuestionSetId(qsId);
                ArrayList<QuestionSet> qs = this.questionSetMapper.selectByQSIdExceptQId(qsId,qId);
                if(qs.isEmpty()){
                    //如果这个group不存在其他q，删掉这个qs
                    this.questionsetDetailMapper.deleteByPrimaryKey(qsId);
                }
                this.questionSetMapper.deleteByPrimaryKey(qsk);
                //更新q
                this.questionMapper.updateQSIdByPrimaryKey(newQSId,qId);
                //新建qs,q 关系
                QuestionSet questionSet = new QuestionSet();
                questionSet.setQuestionSetId(newQSId);
                questionSet.setQuestionId(qId);
                questionSet.setQuestionMark(question.getGrade());
                this.questionSetMapper.insert(questionSet);

            }
        }
        catch (Exception e){
            e.printStackTrace();
            msgList.add("Server error!");
            throw new RuntimeException();
        }
        finally {
            return msgList;
        }
    }

    @Override
    public ArrayList<String> update(QuestionSet record) {
        return null;
    }

    @Override
    public ArrayList<String> delete(QuestionSet questionSet) {
        return null;
    }

    @Override
    public ArrayList<QuestionSet> getList(HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        ArrayList<QuestionSet> qsList = this.questionSetMapper.selectByUserId(userId);
        return qsList;
    }
}
