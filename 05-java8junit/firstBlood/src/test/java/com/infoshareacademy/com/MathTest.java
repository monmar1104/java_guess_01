package com.infoshareacademy.com;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
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


    //todo:
    //napisz następujące testy jednostkowe
    // 1. dodawanie 3 liczb
    // 2. dodawanie gdzie jedna z liczb jest ujemna
    // 3. dodawanie bardzo dużych liczb (gdzie suma wykracza poza zakres integera)
    // 4, jeden z argumentów wejściowych to null




}