package com.isa.homeworks;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statistics {
    ArrayList<String> activities = new ArrayList<>();
    FileReader readActivities = new FileReader("activities.csv");

    private Scanner fileScanner = readActivities.getScanner();

    private Pattern pattern = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2}) (.+),(.+),.+,(.+),(.+),(.+)$");

    void readFile() {

        int i=0;
        while(fileScanner.hasNextLine()) {
            i++;
            String activityItem = fileScanner.nextLine();
            Matcher matcher = pattern.matcher(activityItem);
                if (matcher.matches()) {
                    activities.add(activityItem);
                    System.out.println("ok"+i);
                }
                else {
                    System.out.println("NOK"+i);

                }
        }

//        for (String act : activities) {
//
//            System.out.println(act);
//
//        }
//        System.out.println(activities.size());
    }

}


//        2017-03-23 00:05,2017-03-23 00:10,2,idea,Editing & IDEs,153
//        2017-03-23 00:05,2017-03-23 00:10,0,blog.socialcops.com,Uncategorized,101
//        2017-03-23 00:05,2017-03-23 00:10,2,stackoverflow.com,General Software Development,21
//        2017-03-23 00:05,2017-03-23 00:10,0,google.pl,Search,11