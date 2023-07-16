package org.jiaoda.mtappsys_team01.dao;

import org.apache.ibatis.annotations.*;
import org.jiaoda.mtappsys_team01.entity.questionnaires;

import java.util.List;

@Mapper
public interface IquestionnairesDao {
    @Insert("insert into questionnaires(questionnaire_id,title,description,creator_id) values(#{questionnaire_id},#{title},#{description},#{creator_id})")
    boolean createquestionnaires(questionnaires questionnaire);
    @Select("select max(questionnaire_id) from questionnaires")
    int getmaxqnid();
    @Select("select title,description,created_at,published from questionnaires where questionnaire_id=#{questionnaire_id}")
    questionnaires getquestionnairebyid(int questionnaire_id);

    @Select("select questionnaire_id,title,description,creator_id,created_at,published from questionnaires where creator_id=#{creator_id}")
    List<questionnaires> getquestionnairesbyid(int creator_id);

    @Delete("delete from questionnaires where questionnaire_id=#{questionnaire_id}")
    boolean deletequestionnairebyid(int questionnaire_id);

    @Update("update questionnaires set published =1 where questionnaire_id=#{questionnaire_id}")
    boolean publishbyid(int questionnaire_id);

    @Update("update questionnaires set published =0 where questionnaire_id=#{questionnaire_id}")
    boolean unpublishbyid(int questionnaire_id);

    @Select("select title,description from questionnaires where questionnaire_id = #{questionnaire_id}")
    questionnaires getTitleById(int questionnaire_id);
}
