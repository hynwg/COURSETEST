package com.course.server.service;


import com.course.server.dao.UserInfoDao;
import com.course.server.entity.UserInfo;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    public List<UserInfo> query() {
        return userInfoDao.query();

    }
}
