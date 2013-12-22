package com.jonrah.security;

/**
 * Created by pjo336 on 12/21/13
 * biggertime
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController {

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String printWelcome(ModelMap model, Principal principal ) {
        String name = principal.getName();
        model.addAttribute("username", name);
        return "index/index";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        return "login/login";
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "login/login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        return "login/login";
    }
}