package org.jiaoda.mtappsys_team01.biz;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jiaoda.mtappsys_team01.dao.IAnswerDao;
import org.jiaoda.mtappsys_team01.dao.IOptionDao;
import org.jiaoda.mtappsys_team01.dao.IquestionsDao;
import org.jiaoda.mtappsys_team01.dao.IResponseDao;
import org.jiaoda.mtappsys_team01.entity.Answers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnswerBiz {
    @Autowired
    private IAnswerDao answerdao;
    @Autowired
    private IOptionDao optiondao;
    @Autowired
    private IquestionsDao questiondao;

    public List<String> getAnswerTextById(int q_id)
    {
        List<String> textList = answerdao.getAnswerTextById(q_id);
        return  textList;
    }
    public String insert_answer(Integer res_id, Integer questionnaire_id, String answer_json) {
        //利用jsonObject.get（）方法拿到json里边的属性对应的值。
        // 到数组的时候直接jsonObject.getJSONArray（）拿到这个数组，然后在拿数组里边的每一个对象，
        // 用jsonArray.getJSONObject（）拿到每一个json对象
        //由于传入的数据并不是完整的，先将其转化为json数组
        //JSONArray json = (JSONArray) JSONArray.parse(answer_json);
        JSONArray json = (JSONArray) JSONArray.parse(answer_json);


        for (int i = 0; i < json.size(); i++) {

            JSONObject jsono = (JSONObject) json.get(i);

            //得到答案的类型
            String type = jsono.getString("type");

            Integer question_id = questiondao.select(questionnaire_id, i);
            System.out.print(question_id);


            //按照数据库的设计时多选题会相应被拆分为多个answer（因为需要对应option_id)
            if (type.equals("gap")) {
                System.out.print("答案为主观题答案");
                Answers ans = new Answers();
                String text = jsono.getString("input");
                ans.setAnswer_text(text);
                ans.setQuestion_id(question_id);
                //此处需要根据之前保存的response返回的ID
                ans.setResponse_id(res_id);
                //将封装好的answer对象插入数据库
                answerdao.insert(ans);

            } else if (type.equals("multi")) {
                System.out.print("多选题");
                //ABCD四个选项分别对应的是1234四个数字，用getArry函数来分开

                //int option = jsono.getInteger("selected_option");
                JSONArray jsonObject = jsono.getJSONArray("checkbox");

                List<Integer> list = JSONObject.parseArray(jsonObject.toJSONString(), Integer.class);
                System.out.print(list);


                for (int j = 0; j < list.size(); j++) {
                    Answers ansin = new Answers();
                    //此处的option[i]发挥的作用是相当于数据库里的value，即ABCD的匹配
                    Integer option_id = optiondao.select(question_id, list.get(j));
                    System.out.print(option_id);
                    ansin.setQuestion_id(question_id);
                    //ansin.setSelected_option_id(option_id);
                    //将作答的optionID传给count进行相应的值的增加操作
                    optiondao.update(option_id);
                    ansin.setResponse_id(res_id);
                    answerdao.insert(ansin);
                }
            } else if (type.equals("single")) {
                System.out.print("单选题");
                Answers ansin = new Answers();
                Integer option = jsono.getInteger("radio");
                Integer option_id = optiondao.select(question_id, option);
                System.out.print(option_id);
                ansin.setQuestion_id(question_id);
                //ansin.setSelected_option_id(option_id);
                //将作答的optionID传给count进行相应的值的增加操作
                optiondao.update(option_id);
                ansin.setResponse_id(res_id);
                answerdao.insert(ansin);
            }
        }

        return "ok";
    }

}

//将int转化为单位int构成的数组 如：123->[1][2][3]
//    public static int[] getArray(int number){
//        String s =String.valueOf(number);
//        int arr[]=new int[s.length()];
//
//        for(int i=s.length()-1;i>= 0;i--){
//            arr[i]=number%10;
//            number=number/10;
//        }
//        return arr;
//    }