package com.pjo.jonrah.user;

public enum UserGender {
    
    MALE(0),
    FEMALE(1);
    
    public int genderValue;
    
    private UserGender(int gender) {
        this.genderValue = gender;
    }
    
    public int value() {
        return ordinal();
    }
    
    public static UserGender getGender(int genderInt) {
        for (UserGender gender : UserGender.values()) {
            if(gender.value() == genderInt) {
                return gender;
            }
        }
        return null;
    }
}
