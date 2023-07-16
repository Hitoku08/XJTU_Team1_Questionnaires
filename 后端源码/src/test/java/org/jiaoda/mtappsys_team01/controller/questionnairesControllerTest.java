package org.jiaoda.mtappsys_team01.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jiaoda.mtappsys_team01.entity.questionnaires;
import org.jiaoda.mtappsys_team01.utils.JSONResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class questionnairesControllerTest {
    public void printjson(JSONResult jsonresult){
        System.out.println(jsonresult.getStatus());
        System.out.print(jsonresult.getMsg());
    }
    @Autowired
    questionnariesController qnsc;

    @Test
    public void CreateQuestionnaireTest(){
        questionnaires qns  = new questionnaires();
        qns.setTitle("title1");
        qns.setDescription("desc1");
        qns.setCreator_id(1);
        printjson(qnsc.createquestionnaire(qns));
    }
    @Test
    public void getquestionnairebyidtest(){
        questionnaires qns  = new questionnaires();
        qns.setQuestionnaire_id(1);
        printjson(qnsc.getquestionnairebyid(qns));
    }
    @Test
    public void deletequestionnaireTest(){
        questionnaires qns  = new questionnaires();
        qns.setQuestionnaire_id(1);
        Assertions.assertEquals(200,qnsc.deletequestionnaire(qns).getStatus());
    }
    @Test
    public void publishbyidTest(){
        questionnaires qns  = new questionnaires();
        qns.setQuestionnaire_id(2);
        Assertions.assertEquals(200,qnsc.publishbyid(qns).getStatus());
    }
    @Test
    public void unpublishbyidTest(){
        questionnaires qns  = new questionnaires();
        qns.setQuestionnaire_id(2);
        Assertions.assertEquals(200,qnsc.unpublishbyid(qns).getStatus());
    }
}
