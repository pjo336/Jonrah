package com.jonrah.web.index.controller;

import com.jonrah.user.User;
import com.jonrah.user.UserGender;
import com.jonrah.user.UserType;
import com.jonrah.user.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getIndex() {
        return "index/index";
    }

    @RequestMapping("/register")
    public ModelAndView getRegisterForm(@ModelAttribute("user") User user, BindingResult result) {

        List<UserGender> gender = new ArrayList<UserGender>();
        for (UserGender genderName : UserGender.values()) {
            gender.add(genderName);
        }

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("gender", gender);

        return new ModelAndView("register", "model", model);
    }

    @RequestMapping("/saveUser")
    public ModelAndView saveUserData(@ModelAttribute("user") User user, BindingResult result) {
        System.out.println(user);
        userService.addUser(user);
        return new ModelAndView("redirect:/userList.html");
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUserDataPost(@ModelAttribute("user") User user, BindingResult result) {
        try {
            userService.removeUserById(user.getId());
        } catch (NotFoundException nfe) {
            System.out.println(nfe.getLocalizedMessage());
        }
        return new ModelAndView("redirect:/userList.html");
    }

    @RequestMapping("/userList")
    public ModelAndView getUserList() {
        Map<String, Object> model = new HashMap<String, Object>();
        List<User> users = userService.getAllUsers();
        model.put("user", users);
        return new ModelAndView("user-details", model);
    }

    @RequestMapping("/admin")
    public ModelAndView loadAdminPage() {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView("admin-page", "model", model);
    }

    @RequestMapping("/bootstrap-test")
    public ModelAndView loadTest() {
        Map<String, Object> model = new HashMap<String, Object>();
        return new ModelAndView("bootstrap-test", "model", model);
    }
}