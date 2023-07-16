package org.jiaoda.mtappsys_team01.dao;


import org.jiaoda.mtappsys_team01.entity.responses;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

//mapper层为数据持久层，mapper层的作用为访问数据库，向数据库发送，完成数据的增删改查任务
//response_id, questionnaire_id, user_id, response_date
@Mapper
public interface IResponseDao {

    @Insert({"insert into Responses(questionnaire_id, user_id, response_date)" + "values(#{questionnaire_id},#{user_id},#{response_date})"})
    @Options(useGeneratedKeys=true,keyProperty="response_id")
    void insert(responses response);



}
