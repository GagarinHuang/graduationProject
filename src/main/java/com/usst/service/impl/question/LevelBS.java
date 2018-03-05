package com.usst.service.impl.question;

import com.usst.dao.question.LevelMapper;
import com.usst.entity.question.Level;
import com.usst.service.api.question.ILevel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("levelService")
public class LevelBS implements ILevel {
    @Resource
    LevelMapper levelMapper;

    @Override
    public ArrayList<Level> getList() {
        return this.levelMapper.selectAllRecords();
    }
}
