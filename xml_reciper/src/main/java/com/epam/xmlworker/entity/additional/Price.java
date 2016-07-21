package com.epam.xmlworker.entity.additional;

import java.util.Currency;

/**
 * Created by Kirill Kaluga on 21.07.2016.
 */
public class Price {
    private double amount;
    private String currencyCode;

    public Price() {
    }

    public Price(double amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrency(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
