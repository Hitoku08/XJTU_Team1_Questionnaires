package org.jiaoda.mtappsys_team01.biz;

import org.jiaoda.mtappsys_team01.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserBizTest {
    @Autowired
    UserBiz userbiz;
    @Test
    public void getuserbyidTest(){
        System.out.print(userbiz.getUserByID(9).getUsername());
        Assertions.assertNotNull(userbiz.getUserByID(9).getUsername(),"no null");
    }
    @Test
    public void  CreateUserTest(){
        for(int i = 0;i<20;i++){
            User user = new User();
            user.setUsername("System"+i);
            user.setPassword(String.valueOf((i+1)*2023));
            user.setEmail("System"+i+"@163.com");
            userbiz.createUser(user);
        }
    }
}
