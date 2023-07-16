package org.jiaoda.mtappsys_team01.entity;

public class Answers {
    int answer_id;
    int response_id;
    int question_id;
    String answer_text;


    public int getAnswer_id() {
        return answer_id;
    }

    public void setAnswer_id(int answer_id) {
        this.answer_id = answer_id;
    }

    public int getResponse_id() {
        return response_id;
    }

    public void setResponse_id(int response_id) {
        this.response_id = response_id;
    }

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }





    public Answers(){}

    public Answers(Integer answer_id, Integer response_id, Integer question_id, String answer_text){
        this.answer_id=answer_id;
        this.response_id=response_id;
        this.question_id=question_id;
        this.answer_text=answer_text;

    }
}
