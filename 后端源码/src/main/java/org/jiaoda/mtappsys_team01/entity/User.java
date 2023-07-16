
package org.jiaoda.mtappsys_team01.entity;
import java.sql.*;

public class User {
    private Integer user_id;
    private String username;
    private String password;
    private String email;
    private String phone_number;

    private String salt; // 新增盐值字段
    private boolean logined;

    public boolean getLogined() {
        return this.logined;
    }
    public void setLogined(boolean logined) {
        this.logined = logined;
    }


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    //无参构造方法
    public User(){}
    //有参数构造方法
    public User(Integer user_id,String username,String password,String email,String phone_number){
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
    }
    //封装


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
