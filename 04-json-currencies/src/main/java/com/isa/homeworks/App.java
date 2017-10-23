package com.isa.homeworks;


public class App 
{

    public static void main( String[] args )
    {
       CurrencyJSONReader currencyJSONReader = new CurrencyJSONReader();
       currencyJSONReader.printCurrency();
       currencyJSONReader.showCurrencyConversion();
    }
}
