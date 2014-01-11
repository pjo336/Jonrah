package com.jonrah.trustt.comment.service;

import com.jonrah.trustt.comment.IssueComment;
import com.jonrah.trustt.comment.dao.IssueCommentDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: Peter Johnston
 * Date: 12/28/13
 */

@Service
@Transactional
public class IssueCommentServiceImpl implements IssueCommentService {

    @Autowired
    IssueCommentDao issueCommentDao;

    @Override
    public void addComment(IssueComment comment) {
        issueCommentDao.add(comment);
    }

    @Override
    public List<IssueComment> findAllCommentsByUser(long userId) {
        Criteria crit = issueCommentDao.createCrit(new IssueComment());
        crit.add(Restrictions.eq("commenter.id", userId));
        return issueCommentDao.findCritList(crit);
    }
}
