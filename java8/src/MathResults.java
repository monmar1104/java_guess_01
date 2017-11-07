import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface MathResults {

    static void printMax(Integer s) {
        System.out.println("Wynik działania metody max = " + s);
    }

    static void printMin(Integer s) {
        System.out.println("Wynik działania metody min = " + s);
    }

    default List<Integer> getIntegersForDemo() {
        List<Integer> randomIntegersList = new ArrayList<>();
        Random randomInt = new Random();
        int n = 10000000;

        for (int i = 0; i<n; i++){
            randomIntegersList.add(randomInt.nextInt(n));
        }
        return randomIntegersList;
    }

    static void printStartTime(ZonedDateTime zonedDateTime){
        DateTimeFormatter fullFormat = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        String dateFormated = zonedDateTime.format(fullFormat);
        System.out.println("Data uruchomienia operacji: "+dateFormated);
    }

    static void printDuration(Duration duration){
        System.out.println("Czas wykonania operacji (sekund): "+duration.getSeconds());
    }
}
