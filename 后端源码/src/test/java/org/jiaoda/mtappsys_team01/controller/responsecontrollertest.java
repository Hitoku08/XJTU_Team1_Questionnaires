package org.jiaoda.mtappsys_team01.controller;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class responsecontrollertest {
    @Autowired
    ResponseController responseController;
    @Test
    void insertresponseTest() {
        JSONObject answer=new JSONObject();
        answer.put("id",3);
        answer.put("answer_json","[{\"type\":\"multi\",\"checkbox\":\"[1,2]\"}]");
        responseController.insertresponse(answer);
    }

}
