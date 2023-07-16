package org.jiaoda.mtappsys_team01.biz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class responsebiztest {
    @Autowired
    ResponseBiz responsebiz;
    @Test
    void insert_Response() {
        Integer questionnaire_id;
        questionnaire_id=2;
        System.out.println(responsebiz.insert_Response(questionnaire_id));
        Assertions.assertNotNull(responsebiz.insert_Response(questionnaire_id),"no res_id");
    }
}
