package com.jonrah.web.index.controller;

import com.jonrah.user.User;
import com.jonrah.user.UserGender;
import com.jonrah.user.service.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String printWelcome(ModelMap model, Principal principal ) {
        String name = principal.getName();
        model.addAttribute("username", name);
        return "index";
    }

    @RequestMapping("/register")
    public String getRegisterForm(@ModelAttribute("user") User user, ModelMap model) {

        List<UserGender> gender = new ArrayList<UserGender>();
        for (UserGender genderName : UserGender.values()) {
            gender.add(genderName);
        }

        model.put("gender", gender);

        return "register";
    }

    @RequestMapping("/saveUser")
    public String saveUserData(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "user-list";
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public String deleteUserDataPost(@ModelAttribute("user") User user) {
        try {
            userService.removeUserById(user.getId());
        } catch (NotFoundException nfe) {
            System.out.println(nfe.getLocalizedMessage());
        }
        return "user-list";
    }

    @RequestMapping("/userList")
    public String getUserList(ModelMap model) {
        List<User> users = userService.findAllUsers();
        model.put("user", users);
        return "user-list";
    }

    @RequestMapping("/admin")
    public String loadAdminPage() {
        return "tiles/admin/admin-page";
    }
}