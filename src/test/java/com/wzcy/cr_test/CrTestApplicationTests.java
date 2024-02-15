package com.wzcy.cr_test;
import com.fasterxml.jackson.databind.JsonNode;
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
import static com.sun.javafx.fxml.expression.Expression.equalTo;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;






@ExtendWith(MockitoExtension.class)
class CrTestApplicationTests {

    @InjectMocks
    private UserInfoController userInfoController;
    private MockMvc mockMvc;
    private AutoCloseable closeable;

//    @Mock
//    private UserInfoService userInfoService;
//
    @Mock
    private UserInfoServiceImpl userInfoServiceimpl;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(userInfoController);
        mockMvc = MockMvcBuilders.standaloneSetup(userInfoController).build();
    }


    @Mock
    private UserInfoMapper userInfoMapper;

    @InjectMocks
    private UserInfoServiceImpl userServiceimpl;
    @Test
    void test001() throws Exception {
        UserInfo user = new UserInfo();
        user.setPassWord("qxblshz");
// 使用 JSON 序列化库将对象转换为 JSON 格式的字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonContent = objectMapper.writeValueAsString(user);

        //使用 lenient() 方法来告诉 Mockito 对这个模拟调用放宽限制，不再报告为不必要的模拟行为。
        // 情况1：用户名和密码正确时返回UserInfo对象
        //Mockito.lenient().when(userInfoServiceimpl.login("wzcy", "qxblshz")).thenReturn(user);

        // 情况2：用户名正确但密码不正确时返回null（或抛出异常）
        //Mockito.lenient().when(userInfoServiceimpl.login("wzcy", "misspassword")).thenReturn(null);
        // 或者
        //Mockito.lenient().when(userInfoServiceimpl.login("wzcy", "misspassword")).thenThrow(new RuntimeException("正しいのpasswordを入力してください"));

        // 情况3：用户名正确但密码不正确时返回null（或抛出异常）
        //Mockito.lenient().when(userInfoServiceimpl.login("wzcy", "misspassword")).thenReturn(null);
        // 或者
        //Mockito.lenient().when(userInfoServiceimpl.login("wzcy", "misspassword")).thenThrow(new RuntimeException("正しいのpasswordを入力してください"));

        // 情况4：用户名错误时返回null（或抛出异常）
        // Mockito.lenient().when(userInfoServiceimpl.login("misspassword", "qxblshz")).thenReturn(null);
        //或者
        //Mockito.lenient().when(userInfoServiceimpl.login("misspassword", "misspassword")).thenThrow(new RuntimeException("正しいのusernameを入力してください"));

        //??????????//Mockito.lenient().when(userInfoMapper.getUserByUserName("user")).thenReturn(user);

// MockHttpServletRequestBuilder用于构建模拟 HTTP 请求的工具类。它可以帮助我们构建各种类型的 HTTP 请求，包括 GET、POST、PUT、DELETE 等，并设置请求的 URL、参数、请求体内容、请求头等信息
        MockHttpServletRequestBuilder request =
                MockMvcRequestBuilders.post("/userinfo/login")//post请求
                        .content(jsonContent)//用于接收post请求的内容
                        .contentType(MediaType.APPLICATION_JSON_VALUE);//用于表示发送的是json格式,也可以写from格式

        MvcResult actual = mockMvc.perform(request)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE))//验证contentType是否为json格式
                .andReturn();//返回获得的结果
//actual得到这里面有个code值是200.取出来去断言
        String responseContent = actual.getResponse().getContentAsString();
        JsonNode jsonResponse = objectMapper.readTree(responseContent);
        int actualStatusCode = jsonResponse.get("code").asInt();
//断言
        assertEquals(200,actualStatusCode);
    }




//////测试service层
//
//    //账号密码正确的情况
//    @Test
//    public void testLogin() {
//        // 设置 Mapper 的行为
//        UserInfo userInfo = new UserInfo();
//        userInfo.setPassWord("qxblshz");
//        when(userInfoMapper.getUserByUserName("wzcy")).thenReturn(userInfo);
//        // 调用 Service 的方法
//        UserInfo returnedUser = userServiceimpl.login("wzcy", "qxblshz");
//        // 验证结果
//        assertEquals("qxblshz", returnedUser.getPassWord());
//
//
//    }
//
//    // 空用户名的情况
//    @Test
//    public void testLoginWithBlankUsername() {
//        assertThrows(RuntimeException.class, () -> {
//            userServiceimpl.login(" ", "qxblshz");
//        });
//    }
//
//    // 空密码的情况
//    @Test
//    public void testLoginWithBlankPassword() {
//        assertThrows(RuntimeException.class, () -> {
//            userServiceimpl.login("wzcy", "");
//        });
//    }
//
//
////用户名错误
//    @Test
//    public void testLoginWithWrongUsername() {
//        when(userInfoMapper.getUserByUserName("wrongUser")).thenReturn(null);
//        assertThrows(RuntimeException.class, () -> {
//            userServiceimpl.login("wrongUser", "qxblshz");
//        });
//    }
//
//
//    //密码错误
//    @Test
//    public void testLoginWithWrongPassword() {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setPassWord("qxblshz");
//        when(userInfoMapper.getUserByUserName("wzcy")).thenReturn(userInfo);
//        assertThrows(RuntimeException.class, () -> {
//            userServiceimpl.login("wzcy", "wrongPassword");
//        });
//    }
//
//
//

//   // 测试controller层
//
//    @Test
//    public void testLogin_成功() {
//       UserResult userResult;
//        // 准备
//        UserInfo userInfo = new UserInfo();
//        userInfo.setPassWord("qxblshz");
//        when(userInfoService.login("wzcy", "qxblshz")).thenReturn(userInfo);
//        // 执行
//        userResult= userInfoController.login("wzcy", "qxblshz");
//        // 断言
//        equalTo(userResult, UserResult.ok(userInfo));
//    }
//
//    @Test
//    public void testLogin_用户名错误() {
//        when(userInfoService.login("wzcy", "password")).thenThrow(new RuntimeException("用户名错误"));
//        assertThrows(RuntimeException.class, () -> {
//            userInfoController.login("wzcy", "password");
//        });
//    }
//
//    @Test
//    public void testLogin_密码错误() {
//        UserInfo userInfo = new UserInfo();
//        userInfo.setPassWord("password");
//        when(userInfoService.login("wzcy", "password")).thenThrow(new RuntimeException("密码错误"));
//        assertThrows(RuntimeException.class, () -> {
//            userInfoController.login("wzcy", "password");
//        });
//    }
//
//









//试错记录
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
