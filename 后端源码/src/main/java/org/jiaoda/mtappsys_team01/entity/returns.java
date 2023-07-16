package org.jiaoda.mtappsys_team01.entity;

import java.util.List;

public class returns {
    String title;//表 questionnaires 中的title字段
    String description;//表 questionnaires 中的description字段

    List<returninfo> info;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<returninfo> getInfo() {
        return info;
    }

    public void setInfo(List<returninfo> info) {
        this.info = info;
    }

    public returns(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public returns(){}

}
