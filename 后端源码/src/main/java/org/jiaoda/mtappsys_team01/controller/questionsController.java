package org.jiaoda.mtappsys_team01.controller;
import org.jiaoda.mtappsys_team01.biz.optionBiz;
import org.jiaoda.mtappsys_team01.biz.questionsBiz;
import org.jiaoda.mtappsys_team01.entity.*;
import org.jiaoda.mtappsys_team01.utils.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/questions")
public class questionsController {
    @Autowired
    private questionsBiz questionBiz;
    @Autowired
    private optionBiz optionsBiz;
    @PostMapping("/create")
    @ResponseBody
    public JSONResult createquestion(@RequestBody quesopts quesoptns) {
        for (int i = 0; i < quesoptns.getQuesoptns().size(); i++) {
            int max=questionBiz.getmaxquesid();
            questions question = new questions(max+1, quesoptns.getQuestionnaire_id(), quesoptns.getQuesoptns().get(i).getTitle(), quesoptns.getQuesoptns().get(i).getType(),quesoptns.getQuesoptns().get(i).isMustans());
            if (questionBiz.createQuestion(question)) {//问卷创建成功
            } else {
                return JSONResult.errorMsg("问题创建失败");
            }
            if(quesoptns.getQuesoptns().get(i).getChoices()==null){continue;}
            for (int j = 0; j < quesoptns.getQuesoptns().get(i).getChoices().size(); j++) {
                Option option = new Option(max+1, quesoptns.getQuesoptns().get(i).getChoices().get(j).getText(),quesoptns.getQuesoptns().get(i).getChoices().get(j).getValue());
                if (optionsBiz.createoption(option)) {//问卷创建成功
                } else {
                    return JSONResult.errorMsg("选项创建失败");
                }
            }
        }
        return JSONResult.ok();
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/display")
    @ResponseBody
    public JSONResult getquesoptbyid(@RequestBody questionnaires q){
        List<quesopt> quesopts0=new ArrayList<>();
        List<questions> questions=questionBiz.getquestionbyid(q.getQuestionnaire_id());
        if(questions!=null){
            for(int i=0;i<questions.size();i++){
                List<choice> resultchoice=optionsBiz.getoptionbyid(questions.get(i).getQuestion_id());
                quesopt quesopt0=new quesopt();
                quesopt0.setType(questions.get(i).getQuestion_type());
                quesopt0.setTitle(questions.get(i).getQuestion_content());
                quesopt0.setMustans(questions.get(i).getMustans());
                if(resultchoice.size()!=0){quesopt0.setChoices(resultchoice);}
                quesopts0.add(quesopt0);
            }
            quesopts que=new quesopts(q.getQuestionnaire_id(),quesopts0);
            return JSONResult.ok(que);
        }
        else{
            return JSONResult.errorMsg("问卷选择失败");
        }
    }
}
