package com.isa.homeworks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

class PrintStatistics {
    private Statistics statistics = new Statistics();
    private ArrayList<Integer> spentTimeList = new ArrayList<>(statistics.getSpentTimeList());
    private int sum = statistics.getSum();
    private ArrayList<Integer> spentTimeSumList = new ArrayList<>(statistics.getSpentTimeSumList());


    void printNumberActivities() {
        System.out.println("1) Activities: " + spentTimeList.size());
    }

    void printStatActivities() {
        System.out.println("2) Statystyka wszystkich aktywności:");
        System.out.println("   a) Najkrótsze: " + Collections.min(spentTimeList));
        System.out.println("   b) Najdłuższe: " + Collections.max(spentTimeList));
        System.out.println("   c) Średnia aktywność: " + BigDecimal.valueOf((double) sum / spentTimeList.size()).

                setScale(2, 0));
        System.out.println("   d) Łączny czas pracy: " + (sum / 3600) + " godzin i " + ((sum % 3600) / 60) + " minut");
    }

    void printFacebookHours() {
        for (int i = 0; i < statistics.getFacebookHours().size(); i++) {
            if (i == 0) {
                System.out.print("3) Godziny na facebooku: " + statistics.getFacebookHours().get(i));
            } else if (i == statistics.getFacebookHours().size() - 1) {
                System.out.println(", " + statistics.getFacebookHours().get(i));
            } else {
                System.out.print(", " + statistics.getFacebookHours().get(i));
            }
        }

    }

    void printMostIntensiveHour() {
        System.out.println("4) Najbardziej intensywna godzina: " + statistics.getHoursList().get(spentTimeSumList.indexOf(Collections.max(spentTimeSumList))) + " (Pracowano " + Collections.max(spentTimeSumList) / 60 + " minut)");
    }

}
