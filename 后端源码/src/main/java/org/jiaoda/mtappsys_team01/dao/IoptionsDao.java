package org.jiaoda.mtappsys_team01.dao;

import org.jiaoda.mtappsys_team01.entity.choice;
import org.jiaoda.mtappsys_team01.entity.Option;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.jiaoda.mtappsys_team01.entity.returnoption;

import java.util.List;

@Mapper
public interface IoptionsDao {
    @Insert("insert into options(question_id,option_content,value) values(#{question_id},#{option_content},#{value})")
    boolean createoption(Option option);
    @Select("select option_content as text,value from options where question_id=#{question_id}")
    List<choice> getoptbyid(int question_id);

    /*
    更新
     */
    @Select("select option_content as text, counts from options where question_id = #{q_id}")
    List <returnoption> getOptionById(int q_id);
}
