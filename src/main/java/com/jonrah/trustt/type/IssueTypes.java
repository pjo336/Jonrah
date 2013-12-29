package com.jonrah.trustt.type;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */
public enum IssueTypes {

    BUG("0", "Bug"),
    NEW_FEATURE("1", "New Feature"),
    TASK("2", "Task"),
    DUPLICATE("3", "Duplicate"),
    ENHANCEMENT("4", "Enhancement/Improvement");

    public String issueTypeValue;
    public String issueTypeName;

    private IssueTypes(String type, String name) {
        this.issueTypeValue = type;
        this.issueTypeName = name;
    }

    public String value() {
        return String.valueOf(ordinal());
    }
    public String getIssueTypeName() {return this.issueTypeName;}

    public static IssueTypes getIssueTypes(String issueTypesString) {
        for (IssueTypes type : IssueTypes.values()) {
            if(type.value().equals(issueTypesString)) {
                return type;
            }
        }
        return null;
    }
}
