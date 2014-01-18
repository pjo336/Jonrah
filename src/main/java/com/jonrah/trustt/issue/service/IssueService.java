package com.jonrah.trustt.issue.service;

import com.jonrah.trustt.issue.Issue;
import javassist.NotFoundException;

import java.util.List;

/**
 * Created by Peter Johnston on 12/28/13
 * Jonrah
 */
public interface IssueService {

    /**
     * This adds an issue to the database
     * @param issue
     */
    public void addIssue(Issue issue);

    /**
     * Updates the issue passed in if it is in the database
     * @param issue
     */
    public void updateIssue(Issue issue);

    /**
     * Removes an issue from the database. 2 notes:
     * 1. A non admin should probably not be able to use this
     * 2. We should in general stick to soft deleting, and not actually deleting objects from the database
     * @param issue
     */
    public void removeIssue(Issue issue);

    /**
     * Restores one issue based on the id given. Throws exception if not found. If multiple are found it returns
     * the first found.
     * @param id
     * @return Issue with the given id
     * @throws NotFoundException
     */
    public Issue restoreIssueById(long id) throws NotFoundException;

    /**
     * Return a list of all active Issues in the database
     * @return
     */
    public List<Issue> findAllIssues();

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

    /**
     * Find all issues that do not have a status of closed
     * @return
     */
    public List<Issue> findAllOpenIssues();

    /**
     * Find all issues that have a status of closed
     * @return
     */
    public List<Issue> findAllClosedIssues();
}
