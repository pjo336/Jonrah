package com.jonrah.web.trustt;

import com.jonrah.trustt.issue.Issue;
import com.jonrah.trustt.issue.service.IssueService;
import com.jonrah.trustt.type.IssueTypes;
import com.jonrah.trustt.type.service.IssueTypeService;
import com.jonrah.user.User;
import com.jonrah.web.trustt.forms.IssueForm;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pjo336 on 12/26/13
 * biggertime
 */

@Controller
public class TrusttController {

    @Autowired
    IssueService issueService;
    @Autowired
    IssueTypeService issueTypeService;

    /**
     * Welcome page
     */
    @RequestMapping("/trustt")
    public String getTrustHomePage(ModelMap model) {

        // Find all the issues
        List<Issue> issues = issueService.findAllIssues();

        // List all the possible IssueTypes
        List<String> typeNames = new ArrayList<String>();
        for(IssueTypes type: IssueTypes.values()) {
            typeNames.add(type.name());
        }

        // Put the issues and the possible types on the model
        model.put("issues", issues);
        model.put("types", typeNames);
        return "trustt-homepage";
    }

    /**
     * Serve the issue creation form.
     */
    @RequestMapping(value = "/trustt/create-issue", method = RequestMethod.GET)
    public String serveIssueForm(@ModelAttribute("issue") IssueForm issueForm, ModelMap model) {

        // List all the possible IssueTypes
        List<String> typeNames = new ArrayList<String>();
        for(IssueTypes type: IssueTypes.values()) {
            typeNames.add(type.name());
        }

        // Add the type names on the model
        model.put("types", typeNames);

        return "trustt-create-issue";
    }

    /**
     * submit the issue creation form.
     */
    @RequestMapping(value = "/trustt/create-issue", method = RequestMethod.POST)
    public String submitIssueForm(@ModelAttribute("issue") IssueForm issueForm) {
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
        // Add the issue on the model.
        model.put("issue", issue);

        return "trustt-issue-detail";
    }

    /**
     * Display the details of a single issue.
     */
    @RequestMapping(value = "/trustt/issues", method = RequestMethod.GET)
    public String serveAllIssues(ModelMap model) throws NotFoundException {

        List<Issue> issues = issueService.findAllIssues();
        // Add the issue on the model.
        model.put("issues", issues);

        return "trustt-issue-list";
    }
}
