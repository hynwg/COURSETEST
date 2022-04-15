package com.course.system.service;

import com.course.system.dao.UserInfoDao;
import com.course.system.entity.UserInfo;
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
