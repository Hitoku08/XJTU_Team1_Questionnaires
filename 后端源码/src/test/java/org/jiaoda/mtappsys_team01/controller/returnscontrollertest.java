package org.jiaoda.mtappsys_team01.controller;

import org.jiaoda.mtappsys_team01.entity.questionnaires;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class returnscontrollertest {
    @Autowired
    ReturnsController returnsController;
    @Test
    public void getReturnTest(){
        questionnaires qn = new questionnaires();
        qn.setQuestionnaire_id(3);
        qn.setTitle("title1");
        qn.setCreator_id(2);
        qn.setDescription("desc33");
        System.out.println(returnsController.getReturn(qn).getStatus());
        Assertions.assertEquals(200,returnsController.getReturn(qn).getStatus());
    }
}

