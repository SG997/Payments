package com.app.marketing;

public enum DealsType {
    MONTHLY(25),
    YEARLY(230);

    public final int value;

    private DealsType(int value) {
        this.value = value;
    }
    public static DealsType findByValue(int value){
        for(DealsType v : values()){
            if( v.value == value){
                return v;
            }
        }
        return null;
    }
}