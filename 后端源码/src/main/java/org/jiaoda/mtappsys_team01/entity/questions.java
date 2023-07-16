package org.jiaoda.mtappsys_team01.entity;

public class questions {
    int question_id;
    int questionnaire_id;
    String question_content;
    String question_type;
    boolean mustans;

    public boolean isMustans() {
        return mustans;
    }

    public void setMustans(boolean mustans) {
        this.mustans = mustans;
    }

    public boolean getMustans(){return mustans;}

    public int getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(int question_id) {
        this.question_id = question_id;
    }

    public int getQuestionnaire_id() {
        return questionnaire_id;
    }

    public void setQuestionnaire_id(int questionnaire_id) {
        this.questionnaire_id = questionnaire_id;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }

    public questions(){}

//    public questions(int question_id, int questionnaire_id, String question_content, String question_type) {
//        this.question_id = question_id;
//        this.questionnaire_id = questionnaire_id;
//        this.question_content = question_content;
//        this.question_type = question_type;
//    }

    public questions(int question_id, int questionnaire_id, String question_content, String question_type, boolean mustans) {
        this.question_id = question_id;
        this.questionnaire_id = questionnaire_id;
        this.question_content = question_content;
        this.question_type = question_type;
        this.mustans = mustans;
    }
}
