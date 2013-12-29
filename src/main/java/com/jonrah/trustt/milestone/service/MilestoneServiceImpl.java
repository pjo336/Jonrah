package com.jonrah.trustt.milestone.service;

import com.jonrah.entity.EntityInterface;
import com.jonrah.trustt.milestone.Milestone;
import com.jonrah.trustt.milestone.dao.MilestoneDao;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by pjo336 on 12/28/13
 * biggertime
 */

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MilestoneServiceImpl implements MilestoneService {

    @Autowired
    MilestoneDao milestoneDao;

    @Override
    public List<? extends EntityInterface> findMilestoneByTitle(String title) {
        Criteria crit = milestoneDao.createCrit(new Milestone());
        crit.add(Restrictions.like("title", title + "%"));
        return milestoneDao.findCritList(crit);
    }

    @Override
    public List<? extends EntityInterface> findMilestoneByDueDate(Date date) {
        Criteria crit = milestoneDao.createCrit(new Milestone());
        crit.add(Restrictions.eq("dueDate", date));
        return milestoneDao.findCritList(crit);
    }

    // TODO : handle nulls
    @Override
    public List<? extends EntityInterface> findMilestonesBetweenDates(Date startDate, Date endDate) {
        Criteria crit = milestoneDao.createCrit(new Milestone());
        crit.add(Restrictions.between("dueDate", startDate, endDate));
        return milestoneDao.findCritList(crit);
    }


}
