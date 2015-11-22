package com.pjo.jonrah.web.trustt;

import com.google.gson.Gson;
import com.pjo.jonrah.exceptions.NotFoundException;
import com.pjo.jonrah.trustt.comment.IssueComment;
import com.pjo.jonrah.trustt.comment.service.IssueCommentService;
import com.pjo.jonrah.trustt.issue.Issue;
import com.pjo.jonrah.trustt.issue.IssuePriority;
import com.pjo.jonrah.trustt.issue.IssueStatus;
import com.pjo.jonrah.trustt.issue.service.IssueService;
import com.pjo.jonrah.trustt.type.IssueType;
import com.pjo.jonrah.trustt.type.service.IssueTypeService;
import com.pjo.jonrah.user.User;
import com.pjo.jonrah.user.service.UserService;
import com.pjo.jonrah.util.SecurityUtils;
import com.pjo.jonrah.web.trustt.forms.IssueForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter Johnston on 12/26/13
 * Jonrah
 */

@Controller
public class TrusttController {

    @Autowired
    IssueCommentService issueCommentService;
    @Autowired
    IssueService issueService;
    @Autowired
    IssueTypeService issueTypeService;
    @Autowired
    UserService userService;

    /**
     * Welcome page
     */
    @RequestMapping("/trustt")
    public String getTrustHomePage(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//
//        // Find all the issues
//        List<Issue> issues = issueService.findAllIssues();
//
//        // List all the possible IssueTypes
//        List<IssueType> types = issueTypeService.findAllIssueTypes();
//        List<String> issueTypeNames = new ArrayList<String>();
//        for(IssueType type: types) {
//            issueTypeNames.add(type.getName());
//        }
//
//        // Put the issues and the possible types on the model
//        model.put("issues", issues);
//        model.put("types", issueTypeNames);
        return "trustt-homepage";
    }

    /**
     * Serve the issue creation form.
     */
    @RequestMapping(value = "/trustt/create-issue", method = RequestMethod.GET)
    public String serveIssueForm(@ModelAttribute("issueForm") IssueForm issueForm, ModelMap model) {

        // List all the possible IssueTypes
        List<IssueType> types = issueTypeService.findAllIssueTypes();
        List<String> issueTypeNames = new ArrayList<String>();
        for(IssueType type: types) {
            issueTypeNames.add(type.getName());
        }

        // Add the type names on the model
        model.put("types", issueTypeNames);

        return "trustt-create-issue";
    }

    /**
     * submit the issue creation form.
     */
    @RequestMapping(value = "/trustt/create-issue", method = RequestMethod.POST)
    public String submitIssueForm(@ModelAttribute("issueForm") IssueForm issueForm) {
        Issue issue = new Issue();
        issue.setTitle(issueForm.getTitle());
        issue.setDescription(issueForm.getDescription());
        issue.setType(issueTypeService.findIssueByName(issueForm.getType()).get(0));
        issueService.addIssue(issue);
        return "redirect:/trustt/issue/" + issue.getId();
    }

    /**
     * Display the details of a single issue.
     */
    @RequestMapping(value = "/trustt/issue/{issueId}", method = RequestMethod.GET)
    public String serveSingleIssue(@PathVariable long issueId, ModelMap model) throws NotFoundException {
        Issue issue = issueService.restoreIssueById(issueId);
        List<IssueComment> comments = issueCommentService.findAllCommentsForIssue(issueId);
        // Add the issue and comments on the model.
        model.put("issue", issue);
        model.put("comments", comments);
        return "trustt-issue-detail";
    }

    /**
     * Submit a comment to a single issue
     */
    @RequestMapping(value = "/trustt/issue/{issueId}", method = RequestMethod.POST)
    public String submitCommentSingleIssue(@PathVariable long issueId, @ModelAttribute IssueComment comment, ModelMap model) {
        // Get the user making the comment
        User userCommenting = null;
        Issue connectedIssue = null;
        try {
            userCommenting = userService.restoreUserByLogin(SecurityUtils.getCurrentUserName());
            connectedIssue = issueService.restoreIssueById(issueId);
        } catch(NotFoundException nfe) {
            nfe.printStackTrace();
        }
        if(userCommenting != null && connectedIssue != null) {
            // Create and populate the comment
            IssueComment issueComment = new IssueComment();
            issueComment.setCommenter(userCommenting);
            issueComment.setBugId(connectedIssue);
            issueComment.setComment(comment.getComment());

            // Add the comment to the database
            issueCommentService.addComment(issueComment);
        }

        return "redirect:/trustt/issue/" + issueId;
    }

    /**
     * Display the details of all issues.
     */
    @RequestMapping(value = "/trustt/issues", method = RequestMethod.GET)
    public String serveAllIssues(ModelMap model) throws NotFoundException {

        // Add all the Issue Priorities available to the model
        List<IssuePriority> priorities = new ArrayList<IssuePriority>();
        for(IssuePriority priority: IssuePriority.values()) {
            priorities.add(priority);
        }
        model.put("priorities", priorities);

        // Add all the Issue Statuses available to the model
        List<IssueStatus> statuses = new ArrayList<IssueStatus>();
        for(IssueStatus status: IssueStatus.values()) {
            statuses.add(status);
        }
        model.put("statuses", statuses);

        // Add all the Issue Types available to the model
        List<IssueType> types = issueTypeService.findAllIssueTypes();
        model.put("types", types);

        boolean descending = false;

        List<Issue> openIssues = issueService.findAllOpenIssues();
        List<Issue> closedIssues = issueService.findAllClosedIssues();

        // Sort the issues in descending order
        openIssues = issueService.sortIssueListByDate(descending, openIssues);
        closedIssues = issueService.sortIssueListByDate(descending, closedIssues);

        // Add the issue on the model.
        model.put("openIssues", openIssues);
        model.put("closedIssues", closedIssues);

        return "trustt-issue-list";
    }

    /**
     * Ajax post call to update the assigned user of an issue
     * @param model The model
     * @param request The request, used to receive data from the client
     * @param result The result to the ajax call
     */
    // TODO Probably doesnt need both a model and a result
    @RequestMapping(value = "/trustt/updateAssignedUser", method = RequestMethod.POST)
    public void assignUser(ModelMap model, HttpServletRequest request, HttpServletResponseWrapper result) {
        System.out.println("Assigned user button clicked");
        String userLogin = request.getParameter("userInput");
        User user = null;
        try {
            user = userService.restoreUserByLogin(userLogin);
        } catch(NotFoundException nfe) {
            nfe.printStackTrace();
        }
        model.put("isValid", true);
        model.put("username", user.getUserName());
        try {
            write(result, model);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Retrieves all user names to be added to autocomplete methods for assigning users
     * @param model The model object
     * @param result The result to the ajax call
     */
    @RequestMapping(value = "trustt/retrieveAllUserNames", method = RequestMethod.GET)
    public void fetchAllUserNamesForAutocomplete(ModelMap model, HttpServletResponseWrapper result) {
        List<User> users = userService.findAllUsers();
        List<String> usernames = new ArrayList<String>();
        for(int i = 0; i < users.size(); i++) {
            usernames.add(users.get(i).getUserName());
        }
        model.put("isValid", true);
        model.put("usernames", usernames);
        try {
            write(result, model);
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    /**
     * Private method to convert a result to the client into JSON format
     * @param result The result to the ajax call to convert to JSON
     * @param model Where to put the result
     * @throws IOException
     */
    private void write(HttpServletResponseWrapper result, ModelMap model) throws IOException{
        result.setContentType("application/json");
        result.setCharacterEncoding("UTF-8");
        result.getWriter().write(new Gson().toJson(model));
    }
}
