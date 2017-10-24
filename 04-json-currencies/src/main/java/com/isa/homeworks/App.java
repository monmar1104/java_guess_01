package com.isa.homeworks;


import java.util.Scanner;

public class App
{

    public static void main( String[] args ) {
        CurrencyJSONReader currencyJSONReader = new CurrencyJSONReader();
        boolean onOff = true;
        int choice;
        Scanner scanner = new Scanner(System.in);
        App app = new App();
        while (onOff) {
            app.showMenu();
            choice = Integer.valueOf(scanner.nextLine());
            switch (choice) {
                case 1 : {
                    currencyJSONReader.printCurrency();
                    break;
                }
                case 2 : {
                    currencyJSONReader.showCurrencyConversion();
                    break;
                }
                case 100 : {
                    onOff=false;
                    break;
                }
            }
            }

    }

    void showMenu(){
        System.out.println("---------------------------");
        System.out.println("===========MENU===========\n");
        System.out.println("1. Wyświetl kursy walut.\n");
        System.out.println("2. Przelicz waluty.\n");
        System.out.println("100 aby wyjść z programu.\n");
        System.out.print("Wybierz: ");
    }

}



