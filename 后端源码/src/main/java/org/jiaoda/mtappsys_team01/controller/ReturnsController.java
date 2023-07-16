package org.jiaoda.mtappsys_team01.controller;

import org.jiaoda.mtappsys_team01.biz.AnswerBiz;
import org.jiaoda.mtappsys_team01.biz.optionBiz;
import org.jiaoda.mtappsys_team01.biz.questionnairesBiz;
import org.jiaoda.mtappsys_team01.biz.questionsBiz;
import org.jiaoda.mtappsys_team01.entity.*;
import org.jiaoda.mtappsys_team01.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/results")
public class ReturnsController {
    @Autowired
    private AnswerBiz answersBiz;

    @Autowired
    private optionBiz optionBiz;

    @Autowired
    private questionnairesBiz questionnairesBiz;

    @Autowired
    private questionsBiz questionsBiz;


    @PostMapping("/return")
    @ResponseBody
    public JSONResult getReturn(@RequestBody questionnaires q)
    {
        questionnaires questionnaire = questionnairesBiz.getTileById(q.getQuestionnaire_id());//构造，确保有构造函数；
        returns myreturn =  new returns(questionnaire.getTitle(), questionnaire.getDescription());//有两个字符串了；
        List<questions> quesList = questionsBiz.getQuestionsById(q.getQuestionnaire_id());

        List<returninfo> infoList = new ArrayList<>();

        for(int i=0; i<quesList.size();i++)
        {
            returninfo r = new returninfo(quesList.get(i).getQuestion_content(), quesList.get(i).getQuestion_type());
            //infoList.add(r);
            if(quesList.get(i).getQuestion_type().equals("gap"))///////////////////////////////////////////////////
            {
                List<String> ans = answersBiz.getAnswerTextById(quesList.get(i).getQuestion_id());
                r.setAnswer_text(ans);
            }
            else
            {
                List<returnoption> answ = optionBiz.getOptionById(quesList.get(i).getQuestion_id());
                r.setAnswer_opt(answ);
            }
            infoList.add(r);
        }
        myreturn.setInfo(infoList);

        return JSONResult.ok(myreturn);
    }

}
