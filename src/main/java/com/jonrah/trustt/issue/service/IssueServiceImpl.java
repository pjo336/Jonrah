package com.jonrah.trustt.issue.service;

import com.jonrah.trustt.issue.Issue;
import com.jonrah.trustt.issue.IssueStatus;
import com.jonrah.trustt.issue.dao.IssueDao;
import com.jonrah.trustt.type.service.IssueTypeService;
import com.jonrah.user.User;
import com.jonrah.user.service.UserService;
import com.jonrah.util.SecurityUtils;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pjo336 on 12/28/13
 * biggertime
 */

@Service
@Transactional
public class IssueServiceImpl implements IssueService {

    @Autowired
    IssueDao issueDao;

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
            User user = userService.findUserByLogin(name).get(0);
            issue.setCreatedById(user);
            issueDao.add(issue);
        }
    }

    @Override
    public void updateIssue(Issue issue) {
        issueDao.update(issue);
    }

    @Override
    public void removeIssue(Issue issue) {
        issueDao.remove(issue);
    }

    @Override
    public Issue restoreIssueById(long id) throws NotFoundException {
        Criteria crit = issueDao.createCrit(new Issue());
        crit.add(Restrictions.eq("id", id));
        List<Issue> issues = issueDao.findCritList(crit);
        if(issues.size() == 0) {
            throw new NotFoundException("An issue with this id was not found");
        } else {
            return issues.get(0);
        }
    }

    @Override
    public List<Issue> findAllIssues() {
        Criteria crit = issueDao.createCrit(new Issue());
        return issueDao.findCritList(crit);
    }

    @Override
    public List<Issue> findIssueByTitle(String title) {
        Criteria crit = issueDao.createCrit(new Issue());
        crit.add(Restrictions.like("title", title + "%"));
        return issueDao.findCritList(crit);
    }

    @Override
    public List<Issue> findIssuesAssignedToUser(long userId) {
        Criteria crit = issueDao.createCrit(new Issue());
        crit.add(Restrictions.eq("assignedToId.id", userId));
        return issueDao.findCritList(crit);
    }
}
