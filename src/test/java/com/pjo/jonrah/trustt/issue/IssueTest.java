package com.pjo.jonrah.trustt.issue;

import com.pjo.jonrah.exceptions.NotFoundException;
import com.pjo.jonrah.trustt.comment.service.IssueCommentService;
import com.pjo.jonrah.trustt.issue.service.IssueService;
import com.pjo.jonrah.trustt.milestone.service.MilestoneService;
import com.pjo.jonrah.trustt.type.service.IssueTypeService;
import com.pjo.jonrah.user.User;
import com.pjo.jonrah.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Peter Johnston on 12/25/13
 * Jonrah
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/pjo/jonrah/applicationContext.xml"})
public class IssueTest {

    @Autowired
    private IssueCommentService issueCommentService;
    @Autowired
    private IssueService issueService;
    @Autowired
    private IssueTypeService issueTypeService;
    @Autowired
    private MilestoneService milestoneService;
    @Autowired
    private UserService userService;

    @Test
    public void testIssueDao() throws NotFoundException {
        User peter = userService.restoreUserByLogin("pjo336");
        long userId = peter.getId();
        System.out.println("ID : " + userId);
        List<Issue> list = issueService.findIssuesAssignedToUser(userId);
        System.out.println(list.size());
        for(Issue bug: list) {
            System.out.println(bug.getTitle());
        }

        List<Issue> list2 = issueService.findIssueByTitle("Bug number 1");
        for(Issue bug: list2) {
            System.out.println(bug.getTitle());
        }
    }

    @Test
    public void testIssueService() {
        List<Issue> list = issueService.findIssueByTitle("Bug");
        System.out.println(list.size());
        System.out.println(list.get(0).getTitle());
        System.out.println(list.get(0).getDateAdded());
    }

    /**
     * Quickly create an issue for testing purposes
     * @return
     */
    private Issue createIssue() {
        Issue issue = new Issue();
        issue.setTitle("Bug number 1");
        issue.setStatus("0");
        issue.setDescription("This is a bug");
        issue.setPriority("1");
        return issue;
    }
}
