package org.jiaoda.mtappsys_team01.controller;
import org.jiaoda.mtappsys_team01.entity.User;
import org.jiaoda.mtappsys_team01.utils.JSONResult;
import org.jiaoda.mtappsys_team01.biz.questionnairesBiz;
import org.jiaoda.mtappsys_team01.entity.questionnaires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/questionnaires")
public class questionnariesController {
    @Autowired
    private questionnairesBiz questionnairebiz;
    @PostMapping("/create")
    @ResponseBody
    public JSONResult createquestionnaire(@RequestBody questionnaires questionnaire){
        //调用业务逻辑层中创建用户方法
        int max=questionnairebiz.germaxqnid();
        questionnaire.setQuestionnaire_id(max+1);
        if(questionnairebiz.createQuestionnaires(questionnaire)){//问卷创建成功
            return JSONResult.ok(questionnaire);
        }else{
            return JSONResult.errorMsg("问卷创建失败");
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/display")
    @ResponseBody
    public JSONResult getquestionnairebyid(@RequestBody questionnaires q){
        questionnaires questionnaire=questionnairebiz.getquestionnairebyid(q.getQuestionnaire_id());
        if(questionnaire!=null){
            return JSONResult.ok(questionnaire);
        }
        else{
            return JSONResult.errorMsg("问卷不存在");
        }
    }

    @PostMapping("/logindisplay")
    @ResponseBody
    public JSONResult getquestionnairesbyid(@RequestBody User u){
        List<questionnaires> que=questionnairebiz.getquestionnairesbyid(u.getUser_id());
        if(que!=null){
            return JSONResult.ok(que);
        }
        else{
            return JSONResult.errorMsg("用户不存在");
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public JSONResult deletequestionnaire(@RequestBody questionnaires q){
        if(questionnairebiz.deletequestionnairebyid(q.getQuestionnaire_id())){
            return JSONResult.ok();
        }
        else{
            return JSONResult.errorMsg("删除问卷失败");
        }
    }

    @PostMapping("/publish")
    @ResponseBody
    public JSONResult publishbyid(@RequestBody questionnaires q){
        if(questionnairebiz.publishbyid(q.getQuestionnaire_id())){
            questionnaires questionnaire=questionnairebiz.getquestionnairebyid(q.getQuestionnaire_id());
            return JSONResult.ok(questionnaire);
        }
        else{
            return JSONResult.errorMsg("发布问卷失败");
        }
    }

    @PostMapping("/unpublish")
    @ResponseBody
    public JSONResult unpublishbyid(@RequestBody questionnaires q){
        if(questionnairebiz.unpublishbyid(q.getQuestionnaire_id())){
            questionnaires questionnaire=questionnairebiz.getquestionnairebyid(q.getQuestionnaire_id());
            return JSONResult.ok(questionnaire);
        }
        else{
            return JSONResult.errorMsg("取消发布问卷失败");
        }
    }
}