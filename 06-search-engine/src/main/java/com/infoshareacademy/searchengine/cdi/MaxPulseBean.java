package com.infoshareacademy.searchengine.cdi;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MaxPulseBean implements MaxPulse {

    @Override
    public double getMaxPulseForMan(int age){
        double pulse = 202-(0.55*age);
        return pulse;
    }



    @Override
    public double getMaxPulseForWoman(int age){
        double pulse = 216-(1.09*age);
    return pulse;
    }
}
