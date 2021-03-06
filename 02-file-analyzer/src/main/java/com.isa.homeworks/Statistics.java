package com.isa.homeworks;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

class Statistics {
    private int sum = 0;
    private Set<Integer> facebookHours = new TreeSet<>();
    private ArrayList<Integer> hoursList = new ArrayList<>();
    private ArrayList<Integer> spentTimeSum = new ArrayList<>();
    private ArrayList<Integer> spentTimeList = new ArrayList<>();
    private FileReader activityList = new FileReader();

    Set<Integer> getFacebookHours() {
        for (Activity a : activityList.getActivityList()) {
            if (a.getActivityName().equals("facebook.com")) {
                facebookHours.add(a.getActivityStartHour());
            }
        }
        return facebookHours;
    }

    int getSum() {
        for (Activity b : activityList.getActivityList()) {
            sum = sum + b.getActivitySpentTime();
        }
        return sum;
    }

    ArrayList<Integer> getHoursList() {
        for (Activity c : activityList.getActivityList()) {
            if (!hoursList.contains(c.getActivityStartHour())) {
                hoursList.add(c.getActivityStartHour());
            }
        }
        return hoursList;
    }

    ArrayList<Integer> getSpentTimeList() {
        for (Activity d : activityList.getActivityList()) {
            spentTimeList.add(d.getActivitySpentTime());
        }
        return spentTimeList;
    }

    ArrayList<Integer> getSpentTimeSumList() {
        for (Integer hours : getHoursList()) {
            int hourSum = 0;
            for (Activity actSumSpentTime : activityList.getActivityList()) {
                if (hours.equals(actSumSpentTime.getActivityStartHour())) {
                    hourSum = hourSum + actSumSpentTime.getActivitySpentTime();
                }
            }
            spentTimeSum.add(hourSum);
        }
        return spentTimeSum;
    }
}


