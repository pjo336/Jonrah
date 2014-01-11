package com.jonrah.trustt.issue;

import com.jonrah.trustt.comment.IssueComment;
import com.jonrah.trustt.issue.service.IssueService;
import com.jonrah.trustt.milestone.Milestone;
import com.jonrah.trustt.type.IssueType;
import com.jonrah.trustt.type.IssueTypes;
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

/**
 * Created by pjo336 on 12/25/13
 * biggertime
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/jonrah/applicationContext.xml"})
public class IssueTest {

    @Autowired
    private IssueService issueService;
    @Autowired
    private UserService userService;

    /**
     * Must wipe database each time to run this test
     */
    @Test
    public void testIssue() {
//        if(issueService.findIssueByTitle("").size() == 0 && userService.findAllUsers().size() == 0) {
//            // Create users for the issue
//            User user = new User("herp", "derp", "slerp", "merp", UserGender.MALE, "purp", UserType.FULL_ACCESS);
//            session.saveOrUpdate(user);
//            User peter = new User("pjo336", "123", "Peter", "Johnston", UserGender.MALE, "pjohnston", UserType.ADMIN);
//            session.saveOrUpdate(peter);
//
//            // Create a milestone for the issue
//            Milestone milestone = new Milestone();
//            milestone.setTitle("First Release");
//            session.saveOrUpdate(milestone);
//
//            // Create an issue type
//            IssueType issueType = new IssueType();
//            issueType.setName(IssueTypes.BUG);
//            session.saveOrUpdate(issueType);
//
//            // Now create the issue and attach it to the users, type and milestone created above
//            Issue issue = createIssue();
//            issue.setAssignedToId(peter);
//            issue.setCreatedById(user);
//            issue.setLastModifiedById(user);
//            issue.setOwnerId(peter);
//            issue.setType(issueType);
//            issue.setMilestoneId(milestone);
//            session.saveOrUpdate(issue);
//
//            // Finally add a comment to the bug
//            IssueComment comment = new IssueComment();
//            comment.setComment("This is the first comment on this bug. This bug sucks bruh");
//            comment.setCommenter(peter);
//            comment.setBugId(issue);
//            session.saveOrUpdate(comment);
//        }
//        session.getTransaction().commit();
//        session.close();
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
