package com.infoshareacademy;

import org.junit.Test;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesStatsTest {


    private void statAddPerson(NamesStats stat, Person p1, Person p2) {
        stat.addPerson(p1);
        stat.addPerson(p2);
    }

    @Test
    public void getUniqueNames_theSameNameTwice() {
        //given
        NamesStats stat = new NamesStats();
        Person p1 = new Person("Jas", "Fasola", 1900);
        Person p3 = new Person("Jas", "Wędrowniczek", 1800);

        //when:
        statAddPerson(stat, p1, p3);
        Set<String> uniqueNamesList = stat.getUniqueNames();
        //then
        /** todo C:
            1.  zapoznaj się z kodem produkcyjnym (klasa NamesStats),Co Twoim zdaniem robi ten kod?
            2. sprawdz działanie metody getUniqueNames() za pomocą assertThat (używając assertJ)
        */
        assertThat(uniqueNamesList).contains("jas").containsExactly("jas");
    }




    //     1 napisz test sprawdzający działanie metody getUniqueNames() gdy:
//    a. dodajemy dwa różne imiona
    @Test
    public void getUniqueNames_TwoDifferentNames() {
        //given
        NamesStats stat = new NamesStats();
        Person p1 = new Person("Jas", "Fasola", 1900);
        Person p2 = new Person("Marcin", "Pastwa", 1800);

        //when:
        statAddPerson(stat, p1, p2);
        Set<String> uniqueNamesList = stat.getUniqueNames();
        //then

        assertThat(uniqueNamesList).contains("jas", "marcin");
    }

    /*
    b. dodajemy te same imiona, ale jedno wielkimi literami (sprawdzamy w ten sposób odporność systemu na
            różne dane wejściowe)
      */

    @Test
    public void getUniqueNames_TwoDifferentNamesOneBigLetters() {
        //given
        NamesStats stat = new NamesStats();
        Person p1 = new Person("Jas", "Fasola", 1900);
        Person p2 = new Person("MARCIN", "PASTWA", 1800);

        //when:
        statAddPerson(stat, p1, p2);
        Set<String> uniqueNamesList = stat.getUniqueNames();
        //then

        assertThat(uniqueNamesList).containsOnly("jas", "marcin");
    }
//2. napisz testy dla metody getNamesStats()

    @Test
    public void getNamesStats_threeNamesWithDifferentCapitalization_twoNamesReturned() {
        //given
        NamesStats stat = new NamesStats();
        Person p1 = new Person("Jas", "Fasola", 1900);
        Person p2 = new Person("MARCIN", "PASTWA", 1800);


        //when:
        statAddPerson(stat, p1, p2);

        Map<String, Integer> nameStats = stat.getNamesStats();

        //then

        assertThat(nameStats)
                .containsOnlyKeys("jas", "marcin")
                .containsEntry("jas", 1)
                .containsEntry("marcin", 1);
    }

//3. napisz test dla metody getInitDate()

    @Test
    public void getInitDate_() throws InterruptedException {
        //given
        NamesStats stat = new NamesStats();
        //when:
        Date date = stat.getInitDate();

        //then
        assertThat(date).isCloseTo(new Date(), 100000);
    }

    //4. napisz testy dla metody createTextReport()
    @Test
    public void createTextReport_twoNamesUpperCase() {
        //given
        NamesStats stat = new NamesStats();
        Person p1 = new Person("Jas", "Fasola", 1900);
        Person p2 = new Person("Marcin", "Pastwa", 1800);

        //when:
        statAddPerson(stat, p1, p2);
        String report = stat.createTextReport();

        //then
        assertThat(report).contains("JAS:\t\t1").contains("MARCIN:\t\t1").contains("RAPORT \n");
    }


    /* todo D :
     5. usuń duplikacje z kodu testów:
        - użyj @Before
        - użyj zmiennych statycznych do stworzenia obiektu typu Person
        którego używasz w więcej niż jednym teście (upewnij się, że konstruktor
            klasy Person dla takiego obiektu zostanie odpalony tylko raz)
        - pomyśl jakie metody prywatne można stworzyć żeby uprościć kod klasy testowej

    */
}

