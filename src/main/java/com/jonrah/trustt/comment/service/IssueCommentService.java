package com.jonrah.trustt.comment.service;

import com.jonrah.trustt.comment.IssueComment;

import java.util.List;

/**
 * Created by pjo336 on 12/28/13
 * biggertime
 */

public interface IssueCommentService {

    /**
     * Return a list of all the comments made by the user with this id
     * @param userId
     * @return
     */
    public List<IssueComment> findAllCommentsByUser(long userId);
}
