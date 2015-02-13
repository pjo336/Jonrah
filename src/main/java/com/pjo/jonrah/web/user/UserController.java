package com.pjo.jonrah.web.user;

import com.pjo.jonrah.user.User;
import com.pjo.jonrah.user.UserGender;
import com.pjo.jonrah.user.service.UserService;
import com.pjo.jonrah.web.user.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Peter Johnston
 * @since February 09, 2015
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String getRegisterForm(ModelMap model) {
        model.put("gender", UserGender.values());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleSignup(@ModelAttribute("user") UserForm user) {
//        String salt = BCrypt.gensalt();
//        String password = BCrypt.hashpw(request.getParameter("inputPassword"), salt);
        // TODO hardcoded generic user type okay?
        User userFromForm = new User(user.getUserName(), user.getPassword(), user.getFirstName(), user.getLastName(),
                UserGender.getGender(user.getGender()), user.getEmail());
        userService.addUser(userFromForm);

//        return "forward:/login.do?j_username=" + user.getUserName()
//                + "&j_password=" + user.getPassword();
        return "login";
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "login";
    }

    @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    public String loginerror(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "login";
    }
}
