package com.wzcy.cr_test.controller;

import com.wzcy.cr_test.bean.UserInfo;
import com.wzcy.cr_test.service.UserDetailInfoService;
import com.wzcy.cr_test.service.UserInfoService;
import com.wzcy.cr_test.vo.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin
@RequestMapping("/userinfo")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping("/login")

    public UserResult login(String userName,String passWord){
UserInfo user=userInfoService.login(userName,passWord);
   return UserResult.ok(user);
    }

}
