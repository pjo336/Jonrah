package com.jonrah.trustt.milestone.service;

import com.jonrah.trustt.milestone.Milestone;

import java.util.Date;
import java.util.List;

/**
 * Created by Peter Johnston on 12/28/13
 * Jonrah
 */

public interface MilestoneService {

    /**
     * This adds a milestone to the database
     */
    public void addMilestone(Milestone milestone);

    /**
     * Returns a list of all milestones based on the given title. This currently searches on "like title%" so it can
     * match with more than just exact titles. Could use more retooling in the future
     * @param title
     * @return
     */
    public List<Milestone> findMilestoneByTitle(String title);

    /**
     * Returns a list of all milestones due on the date given
     * @param date
     * @return
     */
    public List<Milestone> findMilestoneByDueDate(Date date);

    /**
     * Returns a list of all milestones between the start date and end date
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Milestone> findMilestonesBetweenDates(Date startDate, Date endDate);
}
