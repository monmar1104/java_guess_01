package com.infoshareacademy;


import java.util.Optional;

public class Math
{
    public Integer dodaj(Integer ... args) {
        Integer sum = 0;
            for (Integer i : args) {
            sum = i==null ? sum : sum+i;
            }
        return sum;
    }
}
