package com.wzcy.cr_test.service;

import com.wzcy.cr_test.bean.UserInfo;

public interface UserInfoService  {
    /***
     * 登录功能根据账号密码查询
     * @param userName 用户账号
     * @param passWord 用户密码
     * @return 指定账号和密码的用户或者null
     */
    UserInfo login(String userName, String passWord);
}
