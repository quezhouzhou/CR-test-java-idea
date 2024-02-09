package com.wzcy.cr_test.mapper;

import com.wzcy.cr_test.bean.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    /***
     * 用户名查询用户对象
     * @param userName
     * @return 用户对象或者null
     */
    UserInfo getUserByUserName(String userName);

}
