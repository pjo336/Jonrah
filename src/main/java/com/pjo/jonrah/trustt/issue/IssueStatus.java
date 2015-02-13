package com.pjo.jonrah.trustt.issue;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */

public enum IssueStatus {

    OPEN("0", "Open"),
    CLOSED("1", "Closed"),
    IN_PROGRESS("2", "In Progress"),
    DUPLICATE("3", "Duplicate"),
    ASSIGNED("4", "Assigned to User");

    private String issueStatusValue;
    private String issueStatusName;

    private IssueStatus(String value, String name) {
        this.issueStatusValue = value;
        this.issueStatusName = name;
    }

    public String value() {
        return String.valueOf(ordinal());
    }

    // TODO fix these
    public String getIssueStatusName() {
        return this.issueStatusName;
    }

    // TODO fix these
    public static IssueStatus getIssueStatus(String issueStatusString) {
        for (IssueStatus type : IssueStatus.values()) {
            if(type.value().equals(issueStatusString)) {
                return type;
            }
        }
        return null;
    }

}
