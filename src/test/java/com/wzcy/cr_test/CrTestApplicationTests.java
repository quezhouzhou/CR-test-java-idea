package com.wzcy.cr_test;


import com.wzcy.cr_test.bean.UserDetailInfo;
import com.wzcy.cr_test.bean.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CrTestApplicationTests {
    CrTest test=new CrTest();
    UserInfo userInfo = new UserInfo();
    UserDetailInfo userDetailInfo = new UserDetailInfo();

    String res="";

@Test
    void test001(){
    String password="";
    System.out.println(test.passwordTest(password));

}
    @Test
    void test002(){
        String password="errorpassword";
        System.out.println(test.passwordTest(password));
    }

    @Test
    void test003(){
        String username="errorusername";
        System.out.println(test.usernameTest(username));
    }

    @Test
    void test004(){
        String username="";
        System.out.println(test.usernameTest(username));

    }

    @Test
    void test005(){
        String username="wzcy";
        System.out.println(test.usernameTest(username));

    }
    @Test
    void test006(){
        String password="qxblshz";
        System.out.println(test.passwordTest(password));

    }
}
