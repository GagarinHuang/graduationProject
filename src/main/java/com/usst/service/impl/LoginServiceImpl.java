package com.usst.service.impl;
import com.usst.dao.ILoginDao;
import com.usst.service.ILoginService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Service("loginService")
public class LoginServiceImpl implements ILoginService {
    @Resource
    private ILoginDao loginDao;

    public List<Map<String, Object>> getList(Map<String, Object> m) {
        return loginDao.getList(m);
    }
}
