package com.isa.homeworks;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        InputStream activitiesStream = App.class.getClassLoader().getResourceAsStream("activities.csv");
        Scanner scanner = new Scanner(activitiesStream).useDelimiter("\n");
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
