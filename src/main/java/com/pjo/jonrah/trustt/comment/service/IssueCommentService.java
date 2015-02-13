package com.pjo.jonrah.trustt.comment.service;

import com.pjo.jonrah.trustt.comment.IssueComment;

import java.util.List;

/**
 * Created by Peter Johnston on 12/28/13
 * Jonrah
 */

public interface IssueCommentService {

    /**
     * Adds a comment to the database
     * @param comment
     */
    public void addComment(IssueComment comment);

    /**
     * Return a list of all the comments applied to the Issue with the given Issue id
     * @param issueId
     * @return List of comments
     */
    public List<IssueComment> findAllCommentsForIssue(long issueId);

    /**
     * Return a list of all the comments made by the user with this id
     * @param userId
     * @return
     */
    public List<IssueComment> findAllCommentsByUser(long userId);
}
