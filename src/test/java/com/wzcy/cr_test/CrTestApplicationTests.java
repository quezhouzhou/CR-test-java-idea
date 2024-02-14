package com.wzcy.cr_test;
import com.wzcy.cr_test.bean.UserInfo;
import com.wzcy.cr_test.controller.UserInfoController;
import com.wzcy.cr_test.mapper.UserInfoMapper;
import com.wzcy.cr_test.service.UserInfoService;
import com.wzcy.cr_test.service.UserInfoServiceImpl;
import com.wzcy.cr_test.vo.UserResult;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.sun.javafx.fxml.expression.Expression.equalTo;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;




@ExtendWith(MockitoExtension.class)
class CrTestApplicationTests {




//测试service层
    @Mock
    private UserInfoMapper userInfoMapper;

    @InjectMocks
    private UserInfoServiceImpl userService;

    @Mock
    private UserInfoService userInfoService;

    @InjectMocks
    private UserInfoController userInfoController;

    //账号密码正确的情况
    @Test
    public void testLogin() {
        // 设置 Mapper 的行为
        UserInfo userInfo = new UserInfo();
        userInfo.setPassWord("qxblshz");
        when(userInfoMapper.getUserByUserName("wzcy")).thenReturn(userInfo);
        // 调用 Service 的方法
        UserInfo returnedUser = userService.login("wzcy", "qxblshz");
        // 验证结果
        assertEquals("qxblshz", returnedUser.getPassWord());


    }

    // 空用户名的情况
    @Test
    public void testLoginWithBlankUsername() {
        assertThrows(RuntimeException.class, () -> {
            userService.login("", "qxblshz");
        });
    }

    // 空密码的情况
    @Test
    public void testLoginWithBlankPassword() {

        assertThrows(RuntimeException.class, () -> {
            userService.login("wzcy", "");
        });
    }


//用户名错误
    @Test
    public void testLoginWithWrongUsername() {
        when(userInfoMapper.getUserByUserName("wzcy")).thenReturn(null);
        assertThrows(RuntimeException.class, () -> {
            userService.login("wrongUser", "qxblshz");
        });
    }


    //密码错误
    @Test
    public void testLoginWithWrongPassword() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPassWord("qxblshz");
        when(userInfoMapper.getUserByUserName("wzcy")).thenReturn(userInfo);
        assertThrows(RuntimeException.class, () -> {
            userService.login("wzcy", "wrongPassword");
        });
    }



   // 测试controller层



    @Test
    public void testLogin_成功() {
        UserResult userResult=new UserResult();
        // 准备
        UserInfo userInfo = new UserInfo();
        userInfo.setPassWord("qxblshz");
        when(userInfoService.login("wzcy", "qxblshz")).thenReturn(userInfo);
        // 执行
        userResult= userInfoController.login("wzcy", "qxblshz");
        // 断言
        equalTo(userResult, UserResult.ok(userInfo));
    }

    @Test
    public void testLogin_用户名错误() {
        when(userInfoService.login("wzcy", "password")).thenThrow(new RuntimeException("用户名错误"));
        assertThrows(RuntimeException.class, () -> {
            userInfoController.login("wzcy", "password");
        });
    }

    @Test
    public void testLogin_密码错误() {
        UserInfo userInfo = new UserInfo();
        userInfo.setPassWord("password");
        when(userInfoService.login("wzcy", "password")).thenThrow(new RuntimeException("密码错误"));
        assertThrows(RuntimeException.class, () -> {
            userInfoController.login("wzcy", "password");
        });
    }
}




//试错记录
//
////private UserInfo userInfo;
////@Mock
////private UserInfoServiceImpl userInfoService;
////private MockMvc mockMvc;
////private  AutoCloseable closeable;
////
////@InjectMocks
////private UserInfoController userInfoController;
////
////@Before
////public void setUp(){
////    MockitoAnnotations.openMocks(this);
////}
////    @BeforeEach
////    void setUp1() {
////      closeable = MockitoAnnotations.openMocks(userInfoController);
////       mockMvc = MockMvcBuilders.standaloneSetup(userInfoController).build();
////    }
////
////    @Test
////    void testMock() throws Exception {
////        when(userInfoService.login("wzcy","1111")).thenThrow(new RuntimeException("正しいのpasswordを入力してください"));
////        MockHttpServletRequestBuilder request =
////                MockMvcRequestBuilders.post("/userinfo/login")
////                        .contentType(MediaType.APPLICATION_JSON_VALUE);
////        String actual = mockMvc.perform(MockMvcRequestBuilders.post("/userinfo/login"))
////                .andExpect(MockMvcResultMatchers.status().isCreated())
////                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))
////                .andReturn().getResponse().getContentAsString(StandardCharsets.UTF_8);
////        Mockito.verify(userInfoService, Mockito.times(1)).login("wzcy","1111");
////        Assert.assertEquals("正しいのpasswordを入力してください",actual);
////    }
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

