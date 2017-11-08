package com.infoshareacademy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class MathTest {

    @Test
    public void dodawanie_dwaArgumenty() {
        // inicjacja obiektu(ów), przygotowanie warunków początkowych (test fixture)
        Math math = new Math();

        // wywołanie metody którą testujemy (method under test)
        Integer wynik = math.dodaj(1, 3);

        // weryfikacja wyników (asercja)
        assertTrue(wynik == 4);
    }
    // 1. dodawanie 3 liczb
    @Test
    public void dodawanie_trzyArgumenty() {
        // inicjacja obiektu(ów), przygotowanie warunków początkowych (test fixture)
        Math math = new Math();

        // wywołanie metody którą testujemy (method under test)
        Integer wynik = math.dodaj(1, 3, 100);

        // weryfikacja wyników (asercja)
        assertTrue(wynik == 104);
    }
    // 2. dodawanie gdzie jedna z liczb jest ujemna
    @Test
    public void dodawanie_trzyArgumentyJednaUjemna() {
        // inicjacja obiektu(ów), przygotowanie warunków początkowych (test fixture)
        Math math = new Math();

        // wywołanie metody którą testujemy (method under test)
        Integer wynik = math.dodaj(1, 3, -100);

        // weryfikacja wyników (asercja)
        assertTrue(wynik == -96);
    }

    // 3. dodawanie bardzo dużych liczb (gdzie suma wykracza poza zakres integera)
    @Test
    public void dodawanie_BigNumbers() {
        // inicjacja obiektu(ów), przygotowanie warunków początkowych (test fixture)
        Math math = new Math();

        // wywołanie metody którą testujemy (method under test)
        Integer wynik = math.dodaj(Integer.MAX_VALUE, 1);

        // weryfikacja wyników (asercja)
        assertEquals((int)wynik,-2147483648);
    }

    // 4, jeden z argumentów wejściowych to null
    @Test
    public void dodawanie_NumbersPlusNull() {
        // inicjacja obiektu(ów), przygotowanie warunków początkowych (test fixture)
        Math math = new Math();

        // wywołanie metody którą testujemy (method under test)
        Integer wynik = math.dodaj(1, null);

        // weryfikacja wyników (asercja)
        assertEquals((int)wynik, 1);
    }




}