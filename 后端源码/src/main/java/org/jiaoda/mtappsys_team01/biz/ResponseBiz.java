package org.jiaoda.mtappsys_team01.biz;


import org.jiaoda.mtappsys_team01.dao.IResponseDao;
import org.jiaoda.mtappsys_team01.entity.responses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ResponseBiz {
    @Autowired
    private IResponseDao responsedao;

    public Integer insert_Response(Integer questionnaire_id) {
        //调用数据访问层中插入回答add_response()方法
        //将json类型的信息传入包装为response实体;
        responses response = new responses();
        //匿名用户均设为0
        response.setUser_id(0);
        response.setQuestionnaire_id(questionnaire_id);
        //获取当前的时间并传入
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
        String now_date = dateFormat.format(date);
        response.setResponse_date(now_date);

        responsedao.insert(response); //此处的插入数据的格式还需要区分
        //返回自增的responseID交给answer对象们用于对其进行插入
        Integer Res_id=response.getResponse_id();
        return Res_id;
    }
}
