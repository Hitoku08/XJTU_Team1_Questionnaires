package org.jiaoda.mtappsys_team01.entity;

import java.util.List;

public class returninfo {
    String type;// 表questions 中question_type 字段
    String question_content; //表questions 中question_type 字段

    List<String> answer_text; //表answer 中answerA_text 字段

    List<returnoption> answer_opt;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public List<String> getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(List<String> answer_text) {
        this.answer_text = answer_text;
    }

    public List<returnoption> getAnswer_opt() {
        return answer_opt;
    }

    public void setAnswer_opt(List<returnoption> answer_opt) {
        this.answer_opt = answer_opt;
    }


    public returninfo(String question_content,String type) {
        this.type = type;
        this.question_content = question_content;
    }

    public  returninfo(){};
}
