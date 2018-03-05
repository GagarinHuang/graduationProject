package com.usst.service.impl.question;

import com.usst.dao.question.ExamTypeMapper;
import com.usst.entity.question.ExamType;
import com.usst.service.api.question.IExamType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("examTypeService")
public class ExamTypeBS implements IExamType {

    @Resource
    ExamTypeMapper examTypeMapper;

    @Override
    public ArrayList<ExamType> getList() {
        return this.examTypeMapper.selectAllRecords();
    }
}
