package org.jiaoda.mtappsys_team01.dao;


import org.apache.ibatis.annotations.Select;
import org.jiaoda.mtappsys_team01.entity.Answers;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface IAnswerDao {

    @Insert({"insert into answers(response_id, question_id,answer_text)" + "values(#{response_id},#{question_id},#{answer_text})"})
    @Options(useGeneratedKeys=true,keyProperty="answer_id")
    void insert(Answers answers); //对进行的回答进行插入数据库的操作

    @Select("select answer_text from answers where question_id = #{question_id}" )
    List<String> getAnswerTextById(int question_id);

}