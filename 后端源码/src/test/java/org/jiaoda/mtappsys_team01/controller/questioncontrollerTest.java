package org.jiaoda.mtappsys_team01.controller;

import org.jiaoda.mtappsys_team01.entity.choice;
import org.jiaoda.mtappsys_team01.entity.quesopt;
import org.jiaoda.mtappsys_team01.entity.quesopts;
import org.jiaoda.mtappsys_team01.entity.questionnaires;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class questioncontrollerTest {
    @Autowired
    questionsController questionscontroller;
    @Test
    public void createQuestionTest(){
        quesopts quesopts = new quesopts();
        quesopts.setQuestionnaire_id(0);
        //quesopts.setQuestionnaire_id(2);
        List<quesopt> quesoptns = new ArrayList<>();
        List<choice> choices_one = new ArrayList<>();
        List<choice> choices_two = new ArrayList<>();
        quesopts.setQuesoptns(quesoptns);
        quesopt quesopt1 = new quesopt("今天学习了吗3","single_choice",choices_one);
        //quesopt quesopt2 = new quesopt("今天吃饭了吗","single_choice",choices_two);
        quesoptns.add(quesopt1);
        //quesoptns.add(quesopt2);
        choice choice1 = new choice("学了3",1);
        //choice choice2 = new choice("美学",2);
        choices_one.add(choice1);
        //choices_one.add(choice2);
        /*
        choice  choice3 = new choice("吃了",1);
        choice  choice4 = new choice("没吃",2);
        choices_two.add(choice3);
        choices_two.add(choice4);
         */
        questionscontroller.createquestion(quesopts);
        //System.out.println(questionscontroller.createquestion(quesopts).getStatus());
        Assertions.assertEquals(200,questionscontroller.createquestion(quesopts).getStatus());
        System.out.print(questionscontroller.createquestion(quesopts).getMsg());
    }
    @Test
    public void getquesoptbyidTest(){
        questionnaires qns  = new questionnaires();
        qns.setQuestionnaire_id(2);//问卷存在，但没有对应的问题
        Assertions.assertEquals(200,questionscontroller.getquesoptbyid(qns).getStatus());
    }
}
