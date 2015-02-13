package com.pjo.jonrah.trustt.type.service;

import com.pjo.jonrah.entity.dao.EntityDao;
import com.pjo.jonrah.trustt.type.IssueType;
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
    private EntityDao entityDao;//entityDao entityDao;

    @Override
    public void addIssueType(IssueType issueType) {
        entityDao.add(issueType);
    }
    @Override
    public List<IssueType> findAllIssueTypes() {
        Criteria crit = entityDao.createCrit(new IssueType());
        return entityDao.findCritList(crit);
    }

    @Override
    public List<IssueType> findIssueByName(String name) {
        Criteria crit = entityDao.createCrit(new IssueType());
        crit.add(Restrictions.like("name", name + "%"));
        return entityDao.findCritList(crit);
    }
}
