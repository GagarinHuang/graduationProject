package com.usst.service.impl.question;

import com.usst.entity.question.Subject;
import com.usst.service.api.question.ILevel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("levelService")
public class LevelBS implements ILevel {
    @Override
    public ArrayList<Subject> getList() {
        return null;
    }
}
