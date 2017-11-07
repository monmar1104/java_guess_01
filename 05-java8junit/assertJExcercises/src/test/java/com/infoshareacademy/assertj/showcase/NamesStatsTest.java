package com.infoshareacademy.assertj.showcase;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NamesStatsTest {

    @Test
    public void getUniqueNames_theSameNameTwice() {
        //given
        NamesStats stat = new NamesStats();
        Person p1 = new Person("Jas", "Fasola", 1900);
        Person p2 = new Person("Jas", "Wędrowniczek", 1800);

        //when:
        stat.addPerson(p1);
        stat.addPerson(p2);

        //then
        /** todo C:
            1.  zapoznaj się z kodem produkcyjnym (klasa NamesStats),Co Twoim zdaniem robi ten kod?
            2. sprawdz działanie metody getUniqueNames() za pomocą assertThat (używając assertJ)
        */

    }


    /* todo D :

     1 napisz test sprawdzający działanie metody getUniqueNames() gdy:
        a. dodajemy dwa różne imiona
        b. dodajemy te same imiona, ale jedno wielkimi literami (sprawdzamy w ten sposób odporność systemu na
            różne dane wejściowe)

     2. napisz testy dla metody getNamesStats()

     3. napisz test dla metody getInitDate()

     4. napisz testy dla metody createTextReport()

     5. usuń duplikacje z kodu testów:
        - użyj @Before
        - użyj zmiennych statycznych do stworzenia obiektu typu Person którego używasz w więcej niż jednym teście (upewnij się, że konstruktor
            klasy Person dla takiego obiektu zostanie odpalony tylko raz)
        - pomyśl jakie metody prywatne można stworzyć żeby uprościć kod klasy testowej

    */







}
