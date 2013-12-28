package com.jonrah.trustt.issue.dao;

import com.jonrah.genericdao.GenericDaoImpl;
import com.jonrah.trustt.issue.Issue;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by pjo336 on 12/27/13
 * biggertime
 */

@Component
public class IssueDaoImpl extends GenericDaoImpl<Issue, Long> implements IssueDao {

    @Override
    public Criteria createCrit() {
        return super.currentSession().getSessionFactory().openSession().createCriteria(Issue.class);
    }

    @Override
    public Issue restoreIssueById(long id) throws NotFoundException {
        return super.restore(id);
    }

    @Override
    public List<Issue> findCritList(Criteria crit) {
        return crit.list();
    }
}
