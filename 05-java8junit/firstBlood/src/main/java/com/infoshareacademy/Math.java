package com.infoshareacademy;


public class Math
{
    public Integer dodaj(Integer ... args) {
        Integer sum = 0;
        for (Integer i : args) {
            if(!i.equals(null)) {
                sum += i;
            }
        }
        return sum;
    }
}
