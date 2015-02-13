package com.pjo.jonrah.trustt.comment.service;

import com.pjo.jonrah.entity.dao.EntityDao;
import com.pjo.jonrah.trustt.comment.IssueComment;
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
    private EntityDao entityDao; //entityDao entityDao;

    @Override
    public void addComment(IssueComment comment) {
        entityDao.add(comment);
    }

    @Override
    public List<IssueComment> findAllCommentsForIssue(long issueId) {
        Criteria crit = entityDao.createCrit(new IssueComment());
        crit.add(Restrictions.eq("bug.id", issueId));
        return entityDao.findCritList(crit);
    }
    @Override
    public List<IssueComment> findAllCommentsByUser(long userId) {
        Criteria crit = entityDao.createCrit(new IssueComment());
        crit.add(Restrictions.eq("commenter.id", userId));
        return entityDao.findCritList(crit);
    }
}
