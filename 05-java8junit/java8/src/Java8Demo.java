import java.time.Clock;
import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 6. W klasie "Java8Demo" zmodyfikuj metodę "getIntegersForDemo" tak,
 * aby zwracała np. 10_000_000 dowolnych liczb.
 * <p>
 * Do interfejsu "MathResults" dodaj statyczną metodę "printStartTime",
 * która przyjmuję parametr typu "ZonedDateTime" i nie zwraca żadnej wartości.
 * Metoda ta ma za zadanie wyświetlić "Data uruchomienia operacji = X",
 * gdzie data będzie wyświetlona przy użyciu "DateTimeFormatter" (FormatStyle.FULL).
 * <p>
 * Do interfejsu dodaj także statyczną metodę "printDuration",
 * która przyjmuje parametr typu "Duration" i nie zwraca żadnej wartości.
 * Metoda ma za zadanie wyświetlić "Czas wykonania operacji (sekund) = X",
 * gdzie podana będzie liczba sekund.
 * <p>
 * Przy użyciu klasy "Clock" wylicz czas od uruchomienia do zakończenia działania metody "main".
 * Powyższy rezultat wyświetl używając metody "printDuration" z interfejsu.
 * <p>
 * Używając metody z interfejsu "printStartTime" na początku metody "main",
 * wyświetl datę uruchomienia operacji wyliczenia wartości min/max.
 */

/**
 * Zadanie nr 7 (pakiet streams)
 * Niech metoda "getIntegersForDemo" w interfejsie "MathResults"
 * zwraca listę dowolnych 10_000_000 liczb.
 * <p>
 * W metodzie "getIntegersForDemo" klasy "Java8Demo" odwołaj się
 * do metody nadpisywanej (słowo kluczowe super) i pobierz powyższe dane testowe z interfejsu.
 * Następnie użyj strumieni w metodzie nadpisującej tak, aby każdy element z danych testowych
 * przemnożyć przez -1 oraz usunąć z nich wszystkie liczby parzyste.
 */


public class Java8Demo implements MathResults {

    public static void main(String args[]) {
        Clock clock = Clock.systemDefaultZone();
        long start = clock.millis();

        Java8Demo java8Demo = new Java8Demo();

        Optional<List<Integer>> integers = Optional.ofNullable(java8Demo.getIntegersForDemo());

        java8Demo.getResult(integers, Collections::max, MathResults::printMax);

        java8Demo.getResult(integers, Collections::min, MathResults::printMin);

        MathResults.printStartTime(ZonedDateTime.of(2021, 8, 4, 10, 22, 33, 0, ZoneId.of("Europe/Warsaw")));
        System.out.println(ZoneId.getAvailableZoneIds().stream().filter(s -> s.contains("W")).collect(Collectors.toList()));
        long stop = clock.millis();
        MathResults.printDuration(Duration.ofMillis(stop - start));

    }

    private void getResult(Optional<List<Integer>> integers,
                           Function<List<Integer>, Integer> function,
                           Consumer<Integer> resultPrinter) {
        if (integers.isPresent()) {
            int result = function.apply(integers.get());
            resultPrinter.accept(result);
        }
    }

    @Override
    public List<Integer> getIntegersForDemo() {
        List<Integer> evenNumbers = MathResults.super.getIntegersForDemo();
        return evenNumbers.stream().map(i -> -i).filter(i -> i % 2 != 0).collect(Collectors.toList());
    }
}
