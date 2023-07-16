package org.jiaoda.mtappsys_team01.biz;

import org.jiaoda.mtappsys_team01.entity.questions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class questionbizTest {
    @Autowired
    questionsBiz questionbiz;
    @Test
    public void CreateQuestionTest(){
        questions questions = new questions();
        questions.setQuestionnaire_id(1);
        questions.setQuestion_content("您使用这个产品开心吗");
        questions.setQuestion_type("single_choice");
        System.out.print(questionbiz.createQuestion(questions));
        Assertions.assertTrue(questionbiz.createQuestion(questions));
    }
    @Test
    public void getmaxquesidTest(){
        System.out.println(questionbiz.getmaxquesid());
        Assertions.assertNotNull(questionbiz.getmaxquesid(),"no");
    }
}
