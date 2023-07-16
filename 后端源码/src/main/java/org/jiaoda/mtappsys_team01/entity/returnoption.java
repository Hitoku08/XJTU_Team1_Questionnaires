package org.jiaoda.mtappsys_team01.entity;

public class returnoption {
    String text;//表 options 中的option_content 字段
    int counts;//表 options 中的counts 字段

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }
}
