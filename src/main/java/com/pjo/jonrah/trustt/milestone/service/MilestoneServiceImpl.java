package com.pjo.jonrah.trustt.milestone.service;

import com.pjo.jonrah.entity.dao.EntityDao;
import com.pjo.jonrah.trustt.milestone.Milestone;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Peter Johnston on 12/28/13
 * Jonrah
 */

@Service
@Transactional
public class MilestoneServiceImpl implements MilestoneService {

    @Autowired
    private EntityDao entityDao; //entityDao entityDao;

    @Override
    public void addMilestone(Milestone milestone) {
        entityDao.add(milestone);
    }

    @Override
    public List<Milestone> findMilestoneByTitle(String title) {
        Criteria crit = entityDao.createCrit(new Milestone());
        crit.add(Restrictions.like("title", title + "%"));
        return entityDao.findCritList(crit);
    }

    @Override
    public List<Milestone> findMilestoneByDueDate(Date date) {
        Criteria crit = entityDao.createCrit(new Milestone());
        crit.add(Restrictions.eq("dueDate", date));
        return entityDao.findCritList(crit);
    }

    // TODO : handle nulls
    @Override
    public List<Milestone> findMilestonesBetweenDates(Date startDate, Date endDate) {
        Criteria crit = entityDao.createCrit(new Milestone());
        crit.add(Restrictions.between("dueDate", startDate, endDate));
        return entityDao.findCritList(crit);
    }


}
