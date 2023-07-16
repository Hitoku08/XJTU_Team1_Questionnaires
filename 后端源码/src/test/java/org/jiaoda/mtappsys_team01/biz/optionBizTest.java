package org.jiaoda.mtappsys_team01.biz;

import org.jiaoda.mtappsys_team01.entity.Option;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class optionBizTest {
    @Autowired
    optionBiz optionbiz;
    @Test
    public void CreateOptionTest(){
        Option option = new Option();
        option.setQuestion_id(2);
        String s = null;
        option.setOption_content(s);
        //System.out.print(optionbiz.createoption(option));
        Assertions.assertTrue(optionbiz.createoption(option));
    }
}
