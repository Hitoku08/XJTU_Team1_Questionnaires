package org.jiaoda.mtappsys_team01.biz;

import org.jiaoda.mtappsys_team01.dao.IUserDao;
import org.jiaoda.mtappsys_team01.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.core.util.StrUtil;
/**
 * 用户业务逻辑层
 */
@Service
public class UserBiz {

    //注入用户的数据访问层
    @Autowired
    private IUserDao userDao;

    //根据用户名查找指定用户对象
//    public User getUserByName(String username) {
//        //调用数据访问层中的根据用户名查找指定用户对象的方法
//        User user = userDao.getUserByUserName(username);
//        return user;
//    }

    public User getUserByID(Integer user_id)
    {
        User user = userDao.getUserByID(user_id);
        return user;
    }
    public void updateLogined(Integer user_id, boolean logined){
        userDao.updateLogined(user_id, logined);
    }

    /**
     * 创建用户
     * @param user
     */
    public boolean createUser(User user){
        // Generate salt and hashed password
        MD5 md5 = MD5.create();
        String temp = md5.digestHex(user.getUsername());
        String tempStart = StrUtil.subWithLength(temp, 0, 6);
        String tempEnd = StrUtil.subSuf(temp, temp.length() - 3);
        String hashedPassword = md5.digestHex(tempStart + user.getPassword() + tempEnd);
        user.setPassword(hashedPassword);
        user.setSalt(tempStart + tempEnd);

        boolean result = true;
        try{
            result = userDao.createUser(user);
        }catch (Exception e){
            e.printStackTrace();
            result  = false;
        }
        return result;
    }
}