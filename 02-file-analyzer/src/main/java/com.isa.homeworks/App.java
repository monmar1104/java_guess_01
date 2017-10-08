package com.isa.homeworks;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class App 
{




    public static void main( String[] args ) {

        ArrayList<Activity> activityList = new ArrayList<>();
        FileReader readActivitiesFile = new FileReader("activities.csv");
        Scanner fileScanner = readActivitiesFile.getScanner();
        Pattern pattern = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2}) (.+):.+,(.+),.+,(.+),(.+),(.+)$");

        int i = 0;
        while (fileScanner.hasNextLine()) {
            Activity activity = new Activity();
            String activityItem = fileScanner.nextLine();
            Matcher matcher = pattern.matcher(activityItem);

            if (matcher.matches()) {
                activity.setActivityName(matcher.group(4));
                activity.setActivitySpentTime(Integer.valueOf(matcher.group(6)));
                activity.setActivityStartHour(Integer.valueOf(matcher.group(2)));

                activityList.add(activity);

            i++;
            }
        }

        for (Activity act: activityList) {

            System.out.println(act.getActivityName());
            System.out.println(act.getActivitySpentTime());
            System.out.println(act.getActivityStartHour());
        }


        System.out.println("1) Activities: "+activityList.size());

    }
}
