package com.usst.service.impl.question;

import com.usst.entity.question.Subject;
import com.usst.service.api.question.IExamType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("examTypeService")
public class ExamTypeBS implements IExamType {
    @Override
    public ArrayList<Subject> getList() {
        return null;
    }
}
