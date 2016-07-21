package com.epam.xmlworker.entity.additional;

/**
 * Created by Kirill Kaluga on 21.07.2016.
 */
public class Price {
    private double amount;
    private CurrencyCode currencyCode;

    public Price() {
    }

    public Price(double amount, CurrencyCode currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrency(CurrencyCode currencyCode) {
        this.currencyCode = currencyCode;
    }
}
