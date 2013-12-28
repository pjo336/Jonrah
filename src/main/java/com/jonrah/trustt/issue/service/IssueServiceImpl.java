package com.jonrah.trustt.issue.service;

import com.jonrah.trustt.issue.Issue;
import com.jonrah.trustt.issue.dao.IssueDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pjo336 on 12/28/13
 * biggertime
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueDao issueDao;

    @Override
    public List<Issue> findIssueByTitle(String title) {
        Criteria crit = issueDao.createCrit();
        crit.add(Restrictions.like("title", title + "%"));
        return issueDao.findCritList(crit);
    }

    @Override
    public List<Issue> findIssuesAssignedToUser(long userId) {
        Criteria crit = issueDao.createCrit();
        crit.add(Restrictions.eq("assignedToId.id", userId));
        return issueDao.findCritList(crit);
    }
}
