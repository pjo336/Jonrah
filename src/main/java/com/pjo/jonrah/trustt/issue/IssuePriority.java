package com.pjo.jonrah.trustt.issue;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */

public enum IssuePriority {

    BLOCKER(0L, "Blocker"),
    CRITICAL(1L, "Critical"),
    HIGH(2L, "High"),
    MEDIUM(3L, "Medium"),
    LOW(4L, "Low"),
    FIX_IF_TIME(5L, "Fix if time");

    public long issuePriorityValue;
    public String issuePriorityName;

    private IssuePriority(long value, String name) {
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