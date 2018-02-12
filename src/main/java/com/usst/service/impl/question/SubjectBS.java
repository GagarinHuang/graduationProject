package com.usst.service.impl.question;

import com.usst.dao.question.SubjectMapper;
import com.usst.entity.question.Subject;
import com.usst.service.api.question.ISubject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("subjectService")
public class SubjectBS implements ISubject{

    @Resource
    SubjectMapper subjectMapper;

    @Override
    public ArrayList<Subject> getList() {
        return this.subjectMapper.selectAllRecords();
    }
}
