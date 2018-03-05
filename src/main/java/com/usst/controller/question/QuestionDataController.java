package com.usst.controller.question;

import com.usst.entity.question.Question;
import com.usst.service.api.question.IQuestion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/question")
public class QuestionDataController {
    @Resource
    IQuestion questionService;

    private static ArrayList<String> msgList = null;

    /*
    * @return 返回一些object,类似question初始值，level list....
    * */
    @RequestMapping(value = "/initialize", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> initializeApi(Question question){
        System.out.println("initializeApi()");
        Map<String,Object> rmap = new HashMap<String,Object>();
        ArrayList<Object> entityList = questionService.initialize(question);
        rmap.put("levelList",entityList.get(0));
        rmap.put("examTypeList",entityList.get(1));
        rmap.put("textBookList",entityList.get(2));
        rmap.put("subjectList",entityList.get(3));
        rmap.put("question",entityList.get(4));
        rmap.put("msg","success");
        return rmap;
    }

    @RequestMapping(value = "/fetch", method = RequestMethod.GET)
    public ModelAndView fetchApi(@RequestParam(required = true,value = "questionId") String questionId,
                                 HttpServletRequest request){
        System.out.println("fetchApi()");
        Question question = questionService.fetch(questionId);
        request.setAttribute("question", question);
        return new ModelAndView("forward:/page/teacherIndex.jsp");
    }

    /*
    * @return 返回消息列表
    * */
    @RequestMapping("/create")
    @ResponseBody
    public Map<String,Object> createApi(Question question,HttpSession session){
        System.out.println("createApi()");
        Map<String,Object> rmap = new HashMap<String,Object>();
        this.msgList = questionService.create(question,session);
        rmap.put("msgList",this.msgList);
        return rmap;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Map<String,Object> updateApi(Question question){
        System.out.println("updateApi()");
        Map<String,Object> rmap = new HashMap<String,Object>();
        this.msgList = questionService.update(question);
        rmap.put("msgList",this.msgList);
        return rmap;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Map<String,Object> deleteApi(Question question){
        System.out.println("updateApi()");
        Map<String,Object> rmap = new HashMap<String,Object>();
        this.msgList = questionService.delete(question);
        rmap.put("msgList",this.msgList);
        return rmap;
    }

    /*
    * 获取附件图片
    * */
    @RequestMapping(value = "/fetchAttach", method = RequestMethod.GET)
    public void fetchAttach(@RequestParam(required = true) String fieldName,
                            @RequestParam(required = true) String questionId,
                            HttpServletResponse response) {
        System.out.println("fetchAttach()");
        Question question = questionService.fetch(questionId);
        try {
            Field field = question.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            //获取属性值
            byte[] bb = (byte[]) field.get(question);
            // 禁止图像缓存。
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/png");
            // 将图像输出到Servlet输出流中。
            ServletOutputStream sos = response.getOutputStream();
            System.out.println("bb==null:"+bb==null);
            System.out.println("sos==null:"+sos==null);
            System.out.println(bb.length);
            sos.write(bb, 0, bb.length);
            sos.close();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @RequestMapping
    public ModelAndView getList(HttpSession session) {
        ArrayList<Question> qList = questionService.getList(session);
        session.setAttribute("questionList",qList);
        return new ModelAndView("/paper/XXX.jsp");
    }

}
