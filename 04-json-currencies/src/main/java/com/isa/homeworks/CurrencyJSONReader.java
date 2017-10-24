package com.isa.homeworks;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Scanner;

class CurrencyJSONReader {


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
        double keyValue;
        String keyCurrencyIn;
        String keyCurrencyOut;
        StringBuilder currencyList;
        currencyList = getCurrencyList();
        BaseCurrency currencyIn;
        BaseCurrency currencyOut;

        System.out.println("");
        boolean checker = true;
        while (checker) {

            System.out.print("Podaj ilość wyluty: [" + currencyList + "]: ");
            try {

                keyValue = Double.valueOf(scanner.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Podałeś nie prawidłową wartość!!! Musisz podać liczbę");
                continue;
            }
            System.out.print("Podaj walutę, którą chcesz przliczyć: ");
            keyCurrencyIn = scanner.nextLine();
            System.out.print("Podaj rodzaj waluty który chcesz otrzymać: ");
            keyCurrencyOut = scanner.nextLine();

            currencyIn = getCurrencyIn(keyCurrencyIn.toUpperCase());
            currencyOut = getCurrencyIn(keyCurrencyOut.toUpperCase());
            if(currencyIn!=null && currencyOut!=null) {
                double result = keyValue * currencyIn.getVallue() / currencyOut.getVallue();
                System.out.println("Wymiana " + keyValue + " " + currencyIn.getCode() + " kosztuje " + BigDecimal.valueOf(result).setScale(2, 0) + " " + currencyOut.getCode());
                System.out.println();
                checker=false;
            }else {
                System.out.println("Wprowadzone dane są niepoprawne. Spróbuj jeszcze raz.");
            }
        }



    }


    BaseCurrency getCurrencyIn(String currencyCode){
        BaseCurrency baseCurrency = new BaseCurrency();
        for (BaseCurrency bc : getCurrency().getCurrencies()){
            if(currencyCode.equals(bc.getCode())){
                baseCurrency.setCode(bc.getCode());
                baseCurrency.setName(bc.getName());
                baseCurrency.setVallue(bc.getVallue());
                return baseCurrency;
            }
        }
        if (currencyCode.equals(getCurrency().getBaseCurrency().getCode())){
            baseCurrency.setCode(getCurrency().getBaseCurrency().getCode());
            baseCurrency.setName(getCurrency().getBaseCurrency().getName());
            baseCurrency.setVallue(getCurrency().getBaseCurrency().getVallue());
            return baseCurrency;
        }else return null;
    }



    StringBuilder getCurrencyList(){
        Currencies currency = getCurrency();
        StringBuilder currencyList = new StringBuilder();

        currencyList.append(currency.getBaseCurrency().getCode()).append(" ");
        for (BaseCurrency currencyName:currency.getCurrencies()) {

           currencyList.append(", ")
                          .append(currencyName.getCode());
        }
        return currencyList;
    }

}
