package com.infoshareacademy.com;


public class Math
{
    public Integer dodaj(Integer ... args) {
        Integer sum = 0;
        for (Integer i : args) {
            sum += i;
        }
        return sum;
    }
}
