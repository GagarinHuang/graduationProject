package com.usst.controller.question;

import com.usst.entity.question.Question;
import com.usst.entity.question.QuestionSet;
import com.usst.service.api.question.IQuestionSet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/questionSet")
public class QuestionSetDataController {

    @Resource
    private IQuestionSet questionSetService;

    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    @ResponseBody
    public ArrayList<QuestionSet> fetchApi(HttpSession session){
        System.out.println("getListApi()");
        ArrayList<QuestionSet> qsList = this.questionSetService.getList(session);
        return qsList;
    }

    @RequestMapping(value = "/group", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> groupApi(@RequestParam(required = true,value = "qIdList") String qIdList,HttpSession session){
        System.out.println("groupApi()");
        System.out.println("qIdList:" + qIdList);
        String[] ids = qIdList.split(",");
        Map<String,Object> rmap = new HashMap<String,Object>();
        ArrayList<String> qIds = new ArrayList<String>();
        ArrayList<String> qsIds = new ArrayList<String>();
        for(int i = 0;i<ids.length;i++){
            String prefix = ids[i].substring(0,2);
            if(prefix.equals("qs")||ids[i].equalsIgnoreCase("Ungroup")){
                qsIds.add(ids[i]);
            }
            else{
                qIds.add(ids[i]);
            }
        }
        ArrayList<String> msgList = this.questionSetService.group(qsIds,qIds,session);
        rmap.put("msgList",msgList);
        return rmap;
    }

    @RequestMapping(value = "/ungroup", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> ungroupApi(@RequestParam(required = true,value = "qIdList") String qIdList,HttpSession session){
        System.out.println("ungroupApi()");
        System.out.println("qIdList:" + qIdList);
        String[] ids = qIdList.split(",");
        Map<String,Object> rmap = new HashMap<String,Object>();
        ArrayList<String> qIds = new ArrayList<String>();
        ArrayList<String> qsIds = new ArrayList<String>();
        for(int i = 0;i<ids.length;i++){
            String prefix = ids[i].substring(0,2);
            if(prefix.equalsIgnoreCase("qs")||ids[i].equalsIgnoreCase("Ungroup")){
                qsIds.add(ids[i]);
            }
            else{
                System.out.println("qId:"+ids[i]);
                qIds.add(ids[i]);
            }
        }
        ArrayList<String> msgList = this.questionSetService.ungroup(qsIds,qIds,session);
        rmap.put("msgList",msgList);
        return rmap;
    }
}
