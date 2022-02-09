package com.app.config.system_data;

public enum UserType {
    UNKNOWN(-1),
    SELF_EMPLOYED(1),
    // ...
    CPA(2);

    public final int type;

    private UserType(int label) {
        this.type = label;
    }
}
