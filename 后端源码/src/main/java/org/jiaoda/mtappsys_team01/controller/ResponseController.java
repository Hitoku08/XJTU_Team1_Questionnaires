package org.jiaoda.mtappsys_team01.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import org.jiaoda.mtappsys_team01.biz.AnswerBiz;
import org.jiaoda.mtappsys_team01.biz.ResponseBiz;
import org.jiaoda.mtappsys_team01.entity.Answers;
import org.jiaoda.mtappsys_team01.utils.JSONResult;
import org.jiaoda.mtappsys_team01.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.net.http.HttpRequest;
import java.util.List;

//前端会传入user_id questionnaire_id 和相应的问题数组
@CrossOrigin(origins="*")
@Controller
@RequestMapping("/response")
public class ResponseController {
    @Autowired
    private ResponseBiz responsebiz; //自动注入response 的数据服务层对象；
    @Autowired
    private AnswerBiz answerbiz;   //自动注入一个answerbiz的数据服务层对象


    @RequestMapping(value = "/product",method = RequestMethod.POST) //user_id=&questionnaire_id={id2}
    //这里的路径设置有待前端的返回值
    @ResponseBody

    public  JSONResult insertresponse(@RequestBody JSONObject answer){
        //根据传入的questionnaire_id在response数据库中增加一条记录
        Integer id=answer.getInteger("id");

        JSONArray answer_json= answer.getJSONArray("answer_json");
        String answer_Sjson=answer_json.toJSONString();
        Integer res_ip;
        System.out.print(answer_json);
        res_ip=responsebiz.insert_Response(id);
        //把传入的JSON数组转化成了answer对象数组，并且交给answer的服务提供层对数据进行处理
        answerbiz.insert_answer(res_ip,id,answer_Sjson);
        return JSONResult.ok();
        //需要增加一个当回答内容为空的判断（如果前端没做的话
        //JSONResult.errorMsg("用户不存在");
    }






}
