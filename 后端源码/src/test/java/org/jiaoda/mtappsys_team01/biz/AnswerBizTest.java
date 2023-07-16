package org.jiaoda.mtappsys_team01.biz;

import org.jiaoda.mtappsys_team01.entity.questions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AnswerBizTest {
    @Autowired
    AnswerBiz answerbiz;
    @Test
    public void getAnswerTextByIdTest(){
        List<String> textlist = answerbiz.getAnswerTextById(28);
        //Assertions.assertEquals(1,textlist.size());
        for(int i=0;i<textlist.size();i++){
            System.out.print(textlist.get(i));
            //System.out.print("not null");
            Assertions.assertNotNull(textlist.get(i),"not null");
        }
    }
    @Test
    public void insert_answerTest(){
        String s = answerbiz.insert_answer(2,1,"i want to sleep");
    }

}
