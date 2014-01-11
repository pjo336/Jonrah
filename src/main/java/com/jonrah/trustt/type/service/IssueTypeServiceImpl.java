package com.jonrah.trustt.type.service;

import com.jonrah.trustt.type.IssueType;
import com.jonrah.trustt.type.dao.IssueTypeDao;
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
public class IssueTypeServiceImpl implements IssueTypeService {

    @Autowired
    IssueTypeDao issueTypeDao;

    @Override
    public void addIssueType(IssueType issueType) {
        issueTypeDao.add(issueType);
    }
    @Override
    public List<IssueType> findAllIssueTypes() {
        Criteria crit = issueTypeDao.createCrit(new IssueType());
        return issueTypeDao.findCritList(crit);
    }

    @Override
    public List<IssueType> findIssueByName(String name) {
        Criteria crit = issueTypeDao.createCrit(new IssueType());
        crit.add(Restrictions.like("name", name + "%"));
        return issueTypeDao.findCritList(crit);
    }
}
