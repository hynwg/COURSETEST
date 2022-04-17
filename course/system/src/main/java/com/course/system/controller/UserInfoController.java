package com.course.system.controller;

import com.course.server.entity.UserInfo;
import com.course.server.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping("/query")
    public List<UserInfo> query() {
        return userInfoService.query();
    }

    @RequestMapping("/test")
    public String test() {
        return "success";
    }
}
