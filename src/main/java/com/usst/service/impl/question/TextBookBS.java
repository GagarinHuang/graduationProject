package com.usst.service.impl.question;

import com.usst.entity.question.Subject;
import com.usst.service.api.question.ITextBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("textBookService")
public class TextBookBS implements ITextBook {
    @Override
    public ArrayList<Subject> getList() {
        return null;
    }
}
