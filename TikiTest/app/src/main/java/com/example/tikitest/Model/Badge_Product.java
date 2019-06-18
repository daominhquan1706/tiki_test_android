package com.example.tikitest.Model;

public class Badge_Product {
    private String code;
    private String option;
    private String text;

    public Badge_Product() {
    }

    public Badge_Product(String code, String option, String text) {
        this.code = code;
        this.option = option;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
