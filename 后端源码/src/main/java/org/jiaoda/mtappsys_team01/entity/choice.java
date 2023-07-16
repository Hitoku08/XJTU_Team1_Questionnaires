package org.jiaoda.mtappsys_team01.entity;

public class choice {
    String text;
    int value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    public choice(){}
    public choice(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public choice(String text) {
        this.text = text;
    }
}