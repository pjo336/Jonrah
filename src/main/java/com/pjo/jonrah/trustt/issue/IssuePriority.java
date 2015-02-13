package com.pjo.jonrah.trustt.issue;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */

public enum IssuePriority {

    BLOCKER("0", "Blocker"),
    CRITICAL("1", "Critical"),
    HIGH("2", "High"),
    MEDIUM("3", "Medium"),
    LOW("4", "Low"),
    FIX_IF_TIME("5", "Fix if time");

    public String issuePriorityValue;
    public String issuePriorityName;

    private IssuePriority(String value, String name) {
        this.issuePriorityValue = value;
        this.issuePriorityName = name;
    }

    public String value() {
        return String.valueOf(ordinal());
    }
    // TODO fix these
    public String getIssuePriorityName() {return this.issuePriorityName;}

    // TODO fix these
    public static IssuePriority getIssuePriorities(String issuePriorityString) {
        for (IssuePriority type : IssuePriority.values()) {
            if(type.value().equals(issuePriorityString)) {
                return type;
            }
        }
        return null;
    }
}