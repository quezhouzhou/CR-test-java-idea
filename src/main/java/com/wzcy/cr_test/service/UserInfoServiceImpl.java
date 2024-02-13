package com.wzcy.cr_test.service;

import com.wzcy.cr_test.bean.UserInfo;
import com.wzcy.cr_test.mapper.UserInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;
    @Override
    public UserInfo login(String userName, String passWord) {
        if (StringUtils.isBlank(userName)) {
            throw new RuntimeException("usernameを入力してください");
        }
        if (StringUtils.isBlank(passWord)) {
            throw new RuntimeException("passwordを入力してください");
        }

        UserInfo user = userInfoMapper.getUserByUserName(userName);
        if (user == null) {
            throw new RuntimeException("正しいのusernameを入力してください");
        }
        if (!user.getPassWord().equals(passWord)) {
            throw new RuntimeException("正しいのpasswordを入力してください");
        }
        return user;


    }
}
