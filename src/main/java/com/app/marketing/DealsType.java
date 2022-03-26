package com.app.marketing;

public enum DealsType {
    MONTHLY(30),
    HALF_YEARLY(150),
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
