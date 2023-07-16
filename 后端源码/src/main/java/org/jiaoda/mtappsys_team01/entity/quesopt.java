package org.jiaoda.mtappsys_team01.entity;
import java.util.List;

public class quesopt {
    String title;
    String type;
    boolean mustans;
    List<choice> choices;


    public boolean isMustans() {
        return mustans;
    }

    public void setMustans(boolean mustans) {
        this.mustans = mustans;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<choice> getChoices() {
        return choices;
    }

    public void setChoices(List<choice> choices) {
        this.choices = choices;
    }

    public quesopt(){}
    public quesopt(String title, String type, List<choice> choices) {
        this.title = title;
        this.type = type;
        this.choices = choices;
    }

    public quesopt(String title, String type, boolean mustans, List<choice> choices) {
        this.title = title;
        this.type = type;
        this.mustans = mustans;
        this.choices = choices;
    }
}
