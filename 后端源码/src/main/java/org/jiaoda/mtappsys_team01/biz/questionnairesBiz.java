package org.jiaoda.mtappsys_team01.biz;

import org.jiaoda.mtappsys_team01.dao.IquestionnairesDao;
import org.jiaoda.mtappsys_team01.entity.questionnaires;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionnairesBiz {
    @Autowired
    private IquestionnairesDao questionnaireDao;

    public boolean createQuestionnaires(questionnaires questionnaire) {
        boolean result = true;
        try {
            //调用数据访问层创建用户的方法
            result = questionnaireDao.createquestionnaires(questionnaire);
        } catch (Exception e) {
            e.printStackTrace();//打印异常堆栈信息
            result = false;//添加用户失败
        }
        return result;
    }

    public int germaxqnid() {
        return questionnaireDao.getmaxqnid();
    }

    public questionnaires getquestionnairebyid(int id) {
        return questionnaireDao.getquestionnairebyid(id);
    }

    public List<questionnaires> getquestionnairesbyid(int id) {
        return questionnaireDao.getquestionnairesbyid(id);
    }

    public questionnaires getTileById(int q_id)
    {
        questionnaires ques = questionnaireDao.getTitleById(q_id);
        return ques;
    }
    public boolean deletequestionnairebyid(int id) {
        boolean result = true;
        try {
            //调用数据访问层创建用户的方法
            result = questionnaireDao.deletequestionnairebyid(id);
        } catch (Exception e) {
            e.printStackTrace();//打印异常堆栈信息
            result = false;//添加用户失败
        }
        return result;
    }

    public boolean publishbyid(int id){
        boolean result = true;
        try {
            //调用数据访问层创建用户的方法
            result = questionnaireDao.publishbyid(id);
        } catch (Exception e) {
            e.printStackTrace();//打印异常堆栈信息
            result = false;//添加用户失败
        }
        return result;
    }

    public boolean unpublishbyid(int id){
        boolean result = true;
        try {
            //调用数据访问层创建用户的方法
            result = questionnaireDao.unpublishbyid(id);
        } catch (Exception e) {
            e.printStackTrace();//打印异常堆栈信息
            result = false;//添加用户失败
        }
        return result;
    }
}

