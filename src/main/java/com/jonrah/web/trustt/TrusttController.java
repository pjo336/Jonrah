package com.jonrah.web.trustt;

import com.jonrah.trustt.issue.Issue;
import com.jonrah.trustt.issue.service.IssueService;
import com.jonrah.trustt.type.IssueTypes;
import com.jonrah.trustt.type.service.IssueTypeService;
import com.jonrah.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    @RequestMapping(value = "/trustt/issue", method = RequestMethod.GET)
    public String serveIssueForm(@ModelAttribute("issue") Issue issue, ModelMap model) {

        // List all the possible IssueTypes
        List<String> typeNames = new ArrayList<String>();
        for(IssueTypes type: IssueTypes.values()) {
            typeNames.add(type.name());
        }

        // Add the type names on the model
        model.put("types", IssueTypes.values());

        return "trustt-create-issue";
    }

    /**
     * submit the issue creation form.
     */
    @RequestMapping(value = "/trustt/issue", method = RequestMethod.POST)
    public String submitIssueForm(@ModelAttribute("issue") Issue issue) {
        // TODO:
        return "trustt-issue-detail";
    }
}
