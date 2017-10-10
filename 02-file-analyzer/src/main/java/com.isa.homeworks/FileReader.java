package com.isa.homeworks;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FileReader {

    private final Pattern pattern = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2}) (.+):.+,(.+),.+,(.+),(.+),(.+)$");
    private ArrayList<Activity> activityList = new ArrayList<>();
    private InputStream activitiesStream = App.class.getClassLoader().getResourceAsStream("activities.csv");
    private Scanner scanner = new Scanner(activitiesStream).useDelimiter("\n");

    ArrayList<Activity> getActivityList() {
        while (scanner.hasNextLine())

        {
            Activity activity = new Activity();
            String activityItem = scanner.nextLine();
            Matcher matcher = pattern.matcher(activityItem);

            if (matcher.matches()) {
                activity.setActivityName(matcher.group(4));
                activity.setActivitySpentTime(Integer.valueOf(matcher.group(6)));
                activity.setActivityStartHour(Integer.valueOf(matcher.group(2)));
                activityList.add(activity);
            }
        }
        return activityList;
    }
}
