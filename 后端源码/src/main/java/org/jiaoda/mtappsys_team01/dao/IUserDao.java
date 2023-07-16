package org.jiaoda.mtappsys_team01.dao;

import org.jiaoda.mtappsys_team01.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 用户数据访问层
 */
@Mapper
public interface IUserDao {
    //根据用户名查找指定用户
    @Select("select user_id, username, password, email, phone_number,logined from users where user_id =#{user_id}")
    User getUserByID(Integer user_id);

    @Update("UPDATE users SET logined = #{logined} WHERE user_id = #{user_id}")
    void updateLogined(Integer user_id, boolean logined);
    /**
     * 创建用户
     * @param user
     */
    @Insert("insert into users(user_id, username, password, salt, email, phone_number) values(#{user_id}, #{username}, #{password}, #{salt}, #{email}, #{phone_number})")
    boolean createUser(User user);


}
