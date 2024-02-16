//package com.wzcy.cr_test;
//
//
//import com.wzcy.cr_test.controller.UserInfoController;
//import com.wzcy.cr_test.service.UserInfoService;
//import com.wzcy.cr_test.service.UserInfoServiceImpl;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;


//试错记录
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




//}
//}
////    @Test
////    void Mocktest(){
////        UserInfo userInfo=new UserInfo();
////        userInfo.setPassWord("qxblshz");
////        userInfo.setUserName("wzcy");
////
////        when(userInfoService.login(anyString(),anyString())).thenReturn(userInfo);
////        // 发起POST请求，模拟登录操作
////        MockHttpServletRequestBuilder actual= MockMvcRequestBuilders.post("/login")
////                       .contentType(MediaType.APPLICATION_JSON_VALUE);
////
////            Assert.assertEquals("正しいのpasswordを入力してください",actual);
////
////
//////// 验证userService的login方法是否被调用了一次，参数为指定的值
//////        verify(userInfoService, times(1)).login("testUsername", "testPassword");
////   }
//
//
//@Test
//    void test001(){
//    String password="";
////    System.out.println(test.passwordTest(password));
//
//}
//    @Test
//    void test002(){
//        String password="errorpassword";
////        System.out.println(test.passwordTest(password));
//    }
//
//    @Test
//    void test003(){
//        String username="errorusername";
////        System.out.println(test.usernameTest(username));
//    }
//
//    @Test
//    void test004(){
//        String username="";
////        System.out.println(test.usernameTest(username));
//
//    }
//
//    @Test
//    void test005(){
//        String username="wzcy";
////        System.out.println(test.usernameTest(username));
//
//    }
//    @Test
//    void test006(){
//        String password="qxblshz";
////        System.out.println(test.passwordTest(password));
//
//    }
    }
