package com.infoshareacademy.searchengine.cdi;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MaxPulseBean implements MaxPulse {

    @Override
    public double getMaxPulseForMan(int age){
        return 202-(0.55*age);
    }



    @Override
    public double getMaxPulseForWoman(int age){
    return 216-(1.09*age);
    }
}
