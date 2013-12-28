package com.jonrah.trustt.issue.dao;

import com.jonrah.genericdao.GenericDao;
import com.jonrah.trustt.issue.Issue;
import javassist.NotFoundException;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by pjo336 on 12/27/13
 * biggertime
 */

public interface IssueDao extends GenericDao<Issue, Long> {

    /**
     * Return the current session fetched from GenericDao
     * @return
     */
    //public Session getCurrentSession();

    /**
     * Create and return a Criteria object. Can be used in the service layer to create custom criteria queries
     * @return
     */
    public Criteria createCrit();

    /**
     * Return an issue with the matching id
     * @param id
     * @return Issue
     */
    public Issue restoreIssueById(long id) throws NotFoundException;

    public List<Issue> findCritList(Criteria crit);
}
