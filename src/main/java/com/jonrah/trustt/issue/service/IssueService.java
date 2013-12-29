package com.jonrah.trustt.issue.service;

import com.jonrah.trustt.issue.Issue;

import java.util.List;

/**
 * Created by pjo336 on 12/28/13
 * biggertime
 */
public interface IssueService {

    public void addIssue(Issue issue);

    public void updateIssue(Issue issue);

    /**
     * Removes an issue from the database. 2 notes:
     * 1. A non admin should probably not be able to use this
     * 2. We should in general stick to soft deleting, and not actually deleting objects from the database
     * @param issue
     */
    public void removeIssue(Issue issue);


    /**
     * Find issues with titles similiar to param given. This currently searches on "like title%" so it can match
     * with more than just exact titles. Could use more retooling in the future
     * @param title
     * @return
     */
    public List<Issue> findIssueByTitle(String title);

    /**
     * Find all issues assigned to the user with the id given in the param
     * @param userId
     * @return
     */
    public List<Issue> findIssuesAssignedToUser(long userId);
}
