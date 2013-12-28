package com.jonrah.web.trustt;

import com.jonrah.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

/**
 * Created by pjo336 on 12/26/13
 * biggertime
 */

@Controller
public class TrusttController {

    @RequestMapping("/trustt")
    public ModelAndView getRegisterForm(@ModelAttribute("user") User user, BindingResult result) {

        return new ModelAndView("trustt/trustt-homepage", "model", new HashMap<String, Object>());
    }
}
