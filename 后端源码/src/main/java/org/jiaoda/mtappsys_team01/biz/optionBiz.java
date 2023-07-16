package org.jiaoda.mtappsys_team01.biz;

import org.jiaoda.mtappsys_team01.entity.Option;
import org.jiaoda.mtappsys_team01.dao.IoptionsDao;
import org.jiaoda.mtappsys_team01.entity.choice;
import org.jiaoda.mtappsys_team01.entity.returnoption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class optionBiz {
    @Autowired
    private IoptionsDao optionDao;
    public boolean createoption(Option option) {
        boolean result = true;
        try{
            //调用数据访问层创建用户的方法
            result = optionDao.createoption(option);
        }catch (Exception e){
            e.printStackTrace();//打印异常堆栈信息
            result  = false;//添加用户失败
        }
        return result;
    }

    public List<choice> getoptionbyid(int id){return optionDao.getoptbyid(id);}


    //////////////////////////////
    public  List<returnoption> getOptionById(int q_id)
    {
        List<returnoption> optionList = optionDao.getOptionById(q_id);
        return optionList;
    }
}
