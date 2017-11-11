
package com.infoshareacademy;


import org.junit.*;

import java.io.UncheckedIOException;

public class OrderOfSpecialTestMethods {


    public OrderOfSpecialTestMethods(){
        System.out.println("Konstruktor");
    }

    @Test
    public void test1() {
        System.out.println("test 1");
    }

    @Test
    public void test2() {
        System.out.println("test 2");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("after class");
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @After
    public void after() throws UncheckedIOException {
        System.out.println("after");
    }

}

    //todo A:
    // 1. odpal wszystkie testy z klasy za jednym kliknięciem / skrótem klawiaturowym (z poziomu IntelliJ)
    // , a następnie z poziomu konsoli (używając mavena).

    // 2. odpal pojedynczą metodę testową (np. test2) z poziomu intelliJ a następnie z poziomu mavena.

    // 3. Zwróć uwagę na kolejność wywoływania metod przez jUnit (obserwując wpisy w terminalu)



    /* todo B:
     1. dodaj konstruktor do klasy, jak myślisz - kiedy będzie odpalony? (dodaj coś na konsolę za każdym razem
        gdy konstruktor jest uruchomiony żeby upewnić się, że dobrze myślisz). ile razy został odpalony konstruktor?

     2. rzuć wyjątek (typu unchecked exception) w jednym z testów. Jak myślisz- jak wyjątek wpłynie na zachowanie się testów?
         czy kolejne testy będą odpalone? Czy metody @after oraz @afterClass zostaną odpalone pomimo wyjątku?
         odpal wszyskie z nich i przetestuj swoje domniemania w praktyce.

     3. rzuć wyjątek  w "Before Class". Zweryfikuj działanie testów.
     4. rzuć wyjątek w "Before". Zweryfikuj działanie testów.
     5. rzuć wyjątek w "After". Zweryfikuj działanie testów.
    */




