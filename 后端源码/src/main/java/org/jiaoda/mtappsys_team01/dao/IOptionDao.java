package org.jiaoda.mtappsys_team01.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.jiaoda.mtappsys_team01.entity.Answers;
import org.jiaoda.mtappsys_team01.entity.Option;

@Mapper
public interface IOptionDao {

    @Select("select option_id from options where question_id=#{questionid} and value=#{value}")
    Integer select(Integer questionid,Integer value);

    @Update("Update options set counts=counts+1 where option_id=#{optionid}")
    void update(Integer optionid);
}
