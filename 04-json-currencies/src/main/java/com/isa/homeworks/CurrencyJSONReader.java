package com.isa.homeworks;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class CurrencyJSONReader {


    Currencies getCurrency() {
        Currencies currency;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader((new FileReader("04-json-currencies/src/main/resources/currencies.json")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        return currency = gson.fromJson(reader, Currencies.class);
    }

    void printCurrency() {
        CurrencyJSONReader currencyJSONReader = new CurrencyJSONReader();
        Currencies currencies = currencyJSONReader.getCurrency();

        System.out.println(currencies.getBaseCurrency().

                getName() + ":" + currencies.getBaseCurrency().

                getVallue());

        for (
                BaseCurrency bc : currencies.getCurrencies())

        {
            System.out.println(bc.getName() + ":" + bc.getVallue());

        }
    }

    void showCurrencyConversion(){

        Scanner scanner = new Scanner(System.in);
        String keyValue = null;
        String keyCurrencyIn = null;
        String keyCurrencyOut = null;
        System.out.print("Podaj ilość wyluty: ");
        keyValue = scanner.nextLine();
        System.out.print("Podaj walutę, którą chcesz przliczyć: ");
        keyCurrencyIn = scanner.nextLine();
        System.out.print("Podaj rodzaj waluty który chcesz otrzymać: ");
        keyCurrencyOut = scanner.nextLine();








    }

}
