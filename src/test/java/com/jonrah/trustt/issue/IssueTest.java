package com.jonrah.trustt.issue;

import com.jonrah.trustt.comment.IssueComment;
import com.jonrah.trustt.comment.service.IssueCommentService;
import com.jonrah.trustt.issue.service.IssueService;
import com.jonrah.trustt.milestone.Milestone;
import com.jonrah.trustt.milestone.service.MilestoneService;
import com.jonrah.trustt.type.IssueType;
import com.jonrah.trustt.type.service.IssueTypeService;
import com.jonrah.user.User;
import com.jonrah.user.UserGender;
import com.jonrah.user.UserType;
import com.jonrah.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * Created by pjo336 on 12/25/13
 * biggertime
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/jonrah/applicationContext.xml"})
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

    /**
     * Must wipe database each time to run this test
     */
    @Test
    public void testIssue() {
        String issueTitle = UUID.randomUUID().toString();
        String userName1 = "TestUser";
        String userName2 = "TestUser2";
        String milestoneName = "First Release";
        User user2, user;
        Milestone milestone;
        if(issueService.findIssueByTitle(issueTitle).size() == 0 ) {

            if(userService.findUserByLogin(userName1).size() == 0 && userService.findUserByLogin(userName2).size() == 0) {
                // Create users for the issue
                user = new User(userName1, userName1, userName1, userName1, UserGender.MALE, userName1, UserType.FULL_ACCESS);
                userService.addUser(user);
                user2 = new User(userName2, userName2, userName2, userName2, UserGender.MALE, userName2, UserType.ADMIN);
                userService.addUser(user2);
            } else {
                user = userService.findUserByLogin(userName1).get(0);
                user2 = userService.findUserByLogin(userName2).get(0);
            }

            if(milestoneService.findMilestoneByTitle(milestoneName).size() == 0) {
                // Create a milestone for the issue
                milestone = new Milestone();
                milestone.setTitle("First Release");
                milestoneService.addMilestone(milestone);
            } else {
                milestone = milestoneService.findMilestoneByTitle(milestoneName).get(0);
            }

            // Grab an issue type
            IssueType issueType = issueTypeService.findAllIssueTypes().get(0);

            // Now create the issue and attach it to the users, type and milestone created above
            Issue issue = createIssue();
            issue.setTitle(issueTitle);
            issue.setAssignedToId(user2);
            issue.setCreatedById(user);
            issue.setLastModifiedById(user);
            issue.setOwnerId(user2);
            issue.setType(issueType.getName());
            issue.setMilestoneId(milestone);

            issueService.addIssue(issue);

            // Finally add a comment to the bug
            IssueComment comment = new IssueComment();
            comment.setComment("This is the first comment on this bug. This bug sucks bruh");
            comment.setCommenter(user2);
            comment.setBugId(issue);
            issueCommentService.addComment(comment);
        }
    }

    @Test
    public void testIssueDao() {
        List<User> users = userService.findUserByLogin("pjo336");
        for(User u: users) {
            System.out.println(u.getFirstName());
        }
        User peter = users.get(0);
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
