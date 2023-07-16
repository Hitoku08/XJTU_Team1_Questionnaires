package org.jiaoda.mtappsys_team01.biz;

import org.jiaoda.mtappsys_team01.entity.questionnaires;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class questionnariesBizTest {
    @Autowired
    questionnairesBiz questionnairesbiz;
    @Test
    public void createQuestionnairesTest(){
        questionnaires questionaires = new questionnaires();
        questionaires.setTitle("");
        questionaires.setDescription("hahah ");
        questionaires.setCreator_id(1);
        System.out.print(questionnairesbiz.createQuestionnaires(questionaires));
    }
    @Test
    public void germanqnidtest(){
        System.out.println(questionnairesbiz.germaxqnid());
    }
    @Test
    public void getquestionnairesbyidtest(){
        questionnaires questionnaires = new questionnaires();
        System.out.print(questionnairesbiz.getquestionnairebyid(1).getTitle());
        System.out.println(questionnairesbiz.getquestionnairebyid(1).getDescription());
        System.out.println(questionnairesbiz.getquestionnairebyid(1).getCreated_at().toString());
    }
}
