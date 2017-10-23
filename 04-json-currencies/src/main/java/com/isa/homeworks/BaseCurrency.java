package com.isa.homeworks;

public class BaseCurrency {
    private String code;
    private String name;
    private double value;

    public double getVallue() {
        return value;
    }

    public void setVallue(float vallue) {
        this.value = vallue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
