package com.pjo.jonrah.trustt.issue.service;

import com.pjo.jonrah.entity.dao.EntityDao;
import com.pjo.jonrah.exceptions.NotFoundException;
import com.pjo.jonrah.trustt.issue.Issue;
import com.pjo.jonrah.trustt.issue.IssueStatus;
import com.pjo.jonrah.trustt.type.service.IssueTypeService;
import com.pjo.jonrah.user.User;
import com.pjo.jonrah.user.service.UserService;
import com.pjo.jonrah.util.SecurityUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Peter Johnston on 12/28/13
 * Jonrah
 */

@Service
@Transactional
public class IssueServiceImpl implements IssueService {

    @Autowired
    EntityDao entityDao;

    @Autowired
    UserService userService;
    @Autowired
    IssueTypeService issueTypeService;

    // TODO fix these methods to involve validation
    @Override
    public void addIssue(Issue issue) throws AccessDeniedException {
        // All created issues start out as open
        issue.setStatus(IssueStatus.OPEN.value());
        // Check who the current user creating this issue is and get their name
        String name = SecurityUtils.getCurrentUserName();
        if(name.equals("anonymousUser")) {
            throw new AccessDeniedException("This user is not logged in and cannot create an issue");
        } else {
            try {
                User user = userService.restoreUserByLogin(name);
                issue.setCreatedById(user);
                entityDao.add(issue);
            } catch(NotFoundException nfe) {
                nfe.printStackTrace();
            }
        }
    }

    @Override
    public void updateIssue(Issue issue) {
        entityDao.saveOrUpdate(issue);
    }

    @Override
    public void removeIssue(Issue issue) {
        entityDao.remove(issue);
    }

    @Override
    public Issue restoreIssueById(long id) throws NotFoundException {
        Criteria crit = entityDao.createCrit(new Issue());
        crit.add(Restrictions.eq("id", id));
        List<Issue> issues = entityDao.findCritList(crit);
        if(issues.size() == 0) {
            throw new NotFoundException("An issue with this id was not found");
        } else {
            return issues.get(0);
        }
    }

    @Override
    public List<Issue> findAllIssues() {
        Criteria crit = entityDao.createCrit(new Issue());
        return entityDao.findCritList(crit);
    }

    @Override
    public List<Issue> findIssueByTitle(String title) {
        Criteria crit = entityDao.createCrit(new Issue());
        crit.add(Restrictions.like("title", title + "%"));
        return entityDao.findCritList(crit);
    }

    @Override
    public List<Issue> findIssuesAssignedToUser(long userId) {
        Criteria crit = entityDao.createCrit(new Issue());
        crit.add(Restrictions.eq("assignedToId.id", userId));
        return entityDao.findCritList(crit);
    }

    @Override
    public List<Issue> findAllOpenIssues() {
        Criteria crit = entityDao.createCrit(new Issue());
        crit.add(Restrictions.ne("status", IssueStatus.CLOSED.value()));
        return entityDao.findCritList(crit);
    }

    @Override
    public List<Issue> findAllClosedIssues() {
        Criteria crit = entityDao.createCrit(new Issue());
        crit.add(Restrictions.eq("status", IssueStatus.CLOSED.value()));
        return entityDao.findCritList(crit);
    }

    @Override
    public List<Issue> sortIssueListByDate(boolean ascending, List<Issue> listToSort) {
        final boolean direction = ascending;
        Collections.sort(listToSort, new Comparator<Issue>() {
            public int compare(Issue o1, Issue o2) {
                if(direction) {
                    return o1.getDateAdded().compareTo(o2.getDateAdded());
                } else {
                    return o2.getDateAdded().compareTo(o1.getDateAdded());
                }
            }
        });
        return listToSort;
    }
}
