package com.isa.homeworks;

class Activity {
    private String activityName;
    //private String activityCategoryName;
    private int activitySpentTime;
    //private String activityStartDate;
    private int activityStartHour;


    String getActivityName() {
        return activityName;
    }

    void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    int getActivitySpentTime() {
        return activitySpentTime;
    }

    void setActivitySpentTime(int activitySpentTime) {
        this.activitySpentTime = activitySpentTime;
    }

    int getActivityStartHour() {
        return activityStartHour;
    }

    void setActivityStartHour(int activityStartHour) {
        this.activityStartHour = activityStartHour;
    }
}
