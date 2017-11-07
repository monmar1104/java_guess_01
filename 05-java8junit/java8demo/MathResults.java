package java8demo;

import examples.date_time.ZonedDateTimeDemo;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public interface MathResults {

    static void printMax(Integer s) {
        System.out.println("Wynik działania metody max = " + s);
    }

    static void printMin(Integer s) {
        System.out.println("Wynik działania metody min = " + s);
    }

    default List<Integer> getIntegersForDemo() {
        return null;
    }

    static void printStartTime(ZonedDateTime zonedDateTime){
        DateTimeFormatter fullFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        String dateFormated = zonedDateTime.format(fullFormat);
        System.out.println("Data uruchomienia operacji: "+dateFormated);
    }

    static void printDuration(Duration duration){
        System.out.println("Czas wykonania operacji: "+duration.getSeconds());
    }
}
