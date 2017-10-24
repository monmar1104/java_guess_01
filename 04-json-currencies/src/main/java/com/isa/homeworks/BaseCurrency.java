package com.isa.homeworks;

class BaseCurrency {
    private String code;
    private String name;
    private double value;

    double getVallue() {
        return value;
    }

    void setVallue(double vallue) {
        this.value = vallue;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getCode() {
        return code;
    }

    void setCode(String code) {
        this.code = code;
    }
}
