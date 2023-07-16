package org.jiaoda.mtappsys_team01.controller;

import org.jiaoda.mtappsys_team01.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class usercontrollerTest {
    @Autowired
    UserController usercontroller;
    @Test
    public void loginTest(){
       User user = new User();
       user.setUser_id(12121);
       System.out.print(usercontroller.login(user).getStatus());
        //PrintJson(usercontroller.login(user.getUsername(),user.getPassword()));
    }
    @Test
    public void registerTest(){
       User user = new User();
      user.setUsername(" ");
      user.setPassword("123888");
      //PrintJson(usercontroller.createUser(user));
      System.out.print(usercontroller.createUser(user).getStatus());
        Assertions.assertEquals(200,usercontroller.createUser(user).getStatus());
  }
  @Test
    public void logoutTest(){
        User user = new User();
        user.setUser_id(12121);
        System.out.print(usercontroller.logout(user).getStatus());
        Assertions.assertEquals(200,usercontroller.logout(user).getStatus());
  }
}
