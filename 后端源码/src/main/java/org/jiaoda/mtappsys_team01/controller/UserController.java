package org.jiaoda.mtappsys_team01.controller;
import org.jiaoda.mtappsys_team01.biz.UserBiz;
import org.jiaoda.mtappsys_team01.entity.User;
import org.jiaoda.mtappsys_team01.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.core.util.StrUtil;

@RestController
@RequestMapping("/user")
public class UserController {
    //注入用户业务逻辑层对象
    @Autowired
    private UserBiz userBiz;

    //登录
    @PostMapping("/login")
    @ResponseBody
    public JSONResult login(@RequestBody User u){
        User user = userBiz.getUserByID(u.getUser_id());
        if(user != null  && user.getLogined()== true){
            return JSONResult.errorMsg("User already logged in");
        }
//        password = user.getPassword();
        if(user!=null){
            MD5 md5 = MD5.create();
            String temp = md5.digestHex(user.getUsername());
            String tempStart = StrUtil.subWithLength(temp, 0, 6);
            String tempEnd = StrUtil.subSuf(temp, temp.length() - 3);
            String hashedPassword = md5.digestHex(tempStart + u.getPassword() + tempEnd);
            if(user.getPassword().equals(hashedPassword)){
                userBiz.updateLogined(u.getUser_id(), true);
                user = userBiz.getUserByID(u.getUser_id());
                return JSONResult.ok(user);
            }else{
                return JSONResult.errorMsg("密码错误");
            }
        }else{
            return JSONResult.errorMsg("用户不存在");
        }
    }

    @PostMapping("/register")
    @ResponseBody
    public JSONResult createUser(@RequestBody User user){
        //调用业务逻辑层中创建用户方法
        if(userBiz.createUser(user)){//用户创建成功
            return JSONResult.ok(user);
        }else{
            return JSONResult.errorMsg("注册失败");
        }
    }

    @PostMapping("/logout")
    @ResponseBody
    public JSONResult logout(@RequestBody User u){
        User user = userBiz.getUserByID(u.getUser_id());
        if(user != null){
            userBiz.updateLogined(u.getUser_id(), false); // Add this line
            return JSONResult.ok("Logged out successfully");
        }else{
            return JSONResult.errorMsg("User not found");
        }
    }
}
