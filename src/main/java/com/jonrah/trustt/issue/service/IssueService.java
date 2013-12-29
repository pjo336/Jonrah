package com.jonrah.trustt.issue.service;

import java.util.List;

/**
 * Created by pjo336 on 12/28/13
 * biggertime
 */
public interface IssueService {

    /**
     * Find issues with titles similiar to param given. This currently searches on "like title%" so it can match
     * with more than just exact titles. Could use more retooling in the future
     * @param title
     * @return
     */
    public List findIssueByTitle(String title);

    /**
     * Find all issues assigned to the user with the id given in the param
     * @param userId
     * @return
     */
    public List findIssuesAssignedToUser(long userId);
}
