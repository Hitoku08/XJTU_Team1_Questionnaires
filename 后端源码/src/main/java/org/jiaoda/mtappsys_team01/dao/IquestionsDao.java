package org.jiaoda.mtappsys_team01.dao;

import org.jiaoda.mtappsys_team01.entity.questions;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface IquestionsDao {
    @Insert("insert into questions(question_id,questionnaire_id,question_content,question_type,mustans) values(#{question_id},#{questionnaire_id},#{question_content},#{question_type},#{mustans})")
    boolean createquestion(questions question);
    @Select("select max(question_id) from questions")
    int maxquesid();

    @Select("select question_content,question_type,question_id,mustans from questions where questionnaire_id=#{questionnaire_id}")
    List<questions> getquestionbyid(int questionnaire_id);

    @Select("select question_id from Questions where questionnaire_id=#{questionnaireid} order by question_id limit #{index},1 ")
    Integer select(Integer questionnaireid,Integer index);

    @Select("select question_content, question_type, question_id from questions where questionnaire_id=#{questionnaire_id}")
    List<questions> getQuestionsById(int questionnaire_id);
}
