package com.isa.homeworks;

import java.util.List;

public class Currencies {
private BaseCurrency baseCurrency;
private List<BaseCurrency> currencies;

    public BaseCurrency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(BaseCurrency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public List<BaseCurrency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<BaseCurrency> currencies) {
        this.currencies = currencies;
    }
}
