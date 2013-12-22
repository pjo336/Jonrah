package com.jonrah.user;

public enum UserType {

    ADMIN("0"),
    SUPERUSER("1"),
    FULL_ACCESS("2"),
    GENERIC("3");
    
    public String userTypeValue;
    
    private UserType(String type) {
        this.userTypeValue = type;
    }
    
    public String value() {
        return String.valueOf(ordinal());
    }
    
    public static UserType getUserType(String userTypeString) {
        for (UserType type : UserType.values()) {
            if(type.value().equals(userTypeString)) {
                return type;
            }
        }
        return null;
    }
}
