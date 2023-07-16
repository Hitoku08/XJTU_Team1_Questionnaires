package org.jiaoda.mtappsys_team01.biz;

import org.jiaoda.mtappsys_team01.dao.IquestionsDao;
import org.jiaoda.mtappsys_team01.entity.questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class questionsBiz {
    @Autowired
    private IquestionsDao questionDao;
    public boolean createQuestion(questions question){
        boolean result = true;
        try{
            //调用数据访问层创建用户的方法
            result = questionDao.createquestion(question);
        }catch (Exception e){
            e.printStackTrace();//打印异常堆栈信息
            result  = false;//添加用户失败
        }
        return result;
    }
    public int getmaxquesid(){return questionDao.maxquesid();}
    public List<questions> getquestionbyid(int questionnaire_id){return questionDao.getquestionbyid(questionnaire_id);}

    public List<questions> getQuestionsById(int q_id)
    {
        List<questions> questionsList = questionDao.getQuestionsById(q_id);
        return questionsList;
    }
}
