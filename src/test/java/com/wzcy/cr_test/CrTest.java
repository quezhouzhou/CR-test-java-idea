//package com.wzcy.cr_test;
//
//
//import com.wzcy.cr_test.controller.UserInfoController;
//import com.wzcy.cr_test.service.UserInfoService;
//import com.wzcy.cr_test.service.UserInfoServiceImpl;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//public class CrTest {
//
//    String res = "";
//@InjectMocks
//UserInfoController userInfoController=new UserInfoController();
//@Mock
//    UserInfoService userInfoService=new UserInfoServiceImpl();
//
//    public String passwordTest(String password) {
//        if (password.equals("")) {
//            res = "密码不能为空";
//        } else if(!password.equals("qxblshz")) {
//            res = "密码错误";
//        } else {
//            res="密码正确";
//        }
//        return res;
//    }
//
//    public String usernameTest(String username) {
//        if (username =="") {
//            res = "账号不能为空";
//        } else if (!username.equals("wzcy")) {
//            res = "账号错误";
//        }else {
//            res="账号正确";
//        }
//        return res;
//    }
//
//}