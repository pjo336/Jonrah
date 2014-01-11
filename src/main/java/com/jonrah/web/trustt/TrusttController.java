package com.jonrah.web.trustt;

import com.jonrah.trustt.issue.Issue;
import com.jonrah.trustt.issue.service.IssueService;
import com.jonrah.trustt.type.IssueTypes;
import com.jonrah.trustt.type.service.IssueTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/trustt")
    public ModelAndView getTrustHomePage(@ModelAttribute("issue") Issue issue, BindingResult result) {
        Map<String, Object> model = new HashMap<String, Object>();

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
        return new ModelAndView("trustt/trustt-homepage", model);
    }

    @RequestMapping("/createIssue")
    public ModelAndView createIssue(@ModelAttribute("issue") Issue issue, BindingResult result) {
        issueService.addIssue(issue);
        return new ModelAndView("redirect:/trustt.html");
    }
}
