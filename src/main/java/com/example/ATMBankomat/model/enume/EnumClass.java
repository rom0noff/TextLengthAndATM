package com.example.ATMBankomat.model.enume;

public class EnumClass {
    private String moneyType;
    private String code;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    EnumClass() {
    }

    EnumClass(String name, String code,String moneyType) {
        this.moneyType = moneyType;
        this.code = code;
        this.name = name;
    }
}
