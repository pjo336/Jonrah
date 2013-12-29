package com.jonrah.trustt.milestone.service;

import com.jonrah.entity.EntityInterface;

import java.util.Date;
import java.util.List;

/**
 * Created by pjo336 on 12/28/13
 * biggertime
 */

public interface MilestoneService {

    /**
     * Returns a list of all milestones based on the given title. This currently searches on "like title%" so it can
     * match with more than just exact titles. Could use more retooling in the future
     * @param title
     * @return
     */
    public List<? extends EntityInterface> findMilestoneByTitle(String title);

    /**
     * Returns a list of all milestones due on the date given
     * @param date
     * @return
     */
    public List<? extends EntityInterface> findMilestoneByDueDate(Date date);

    /**
     * Returns a list of all milestones between the start date and end date
     * @param startDate
     * @param endDate
     * @return
     */
    public List<? extends EntityInterface> findMilestonesBetweenDates(Date startDate, Date endDate);
}
