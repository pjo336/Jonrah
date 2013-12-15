package com.bt.user;

public enum UserType {

    ADMIN(0),
    SUPERUSER(1),
    FULL_ACCESS(2),
    GENERIC(3);
    
    public int userTypeValue;
    
    private UserType(int type) {
        this.userTypeValue = type;
    }
    
    public int value() {
        return ordinal();
    }
    
    public static UserType getUserType(int userInt) {
        for (UserType type : UserType.values()) {
            if(type.value() == userInt) {
                return type;
            }
        }
        return null;
    }
}
