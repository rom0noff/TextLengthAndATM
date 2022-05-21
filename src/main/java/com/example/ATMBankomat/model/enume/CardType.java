package com.example.ATMBankomat.model.enume;

public enum CardType {
    UZCARD("SUM"),
    HUMO("SUM"),
    VISA("DOLLAR"),
    UNIONPAY("YEN");

    private String currency;
    CardType(String currency){
        this.currency = currency;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
