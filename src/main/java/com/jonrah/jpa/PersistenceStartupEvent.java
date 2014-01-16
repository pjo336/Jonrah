package com.jonrah.jpa;

import com.jonrah.trustt.type.IssueType;
import com.jonrah.trustt.type.service.IssueTypeService;
import com.jonrah.user.User;
import com.jonrah.user.UserGender;
import com.jonrah.user.UserType;
import com.jonrah.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Peter Johnston on 1/11/14
 * Jonrah
 * PersistenceStartupEvent performs neccessary actions on the startup of the application.
 * This includes ensuring the admin account exists and the issue types.
 */

@Component
public class PersistenceStartupEvent implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    IssueTypeService issueTypeService;
    @Autowired
    UserService userService;


    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent ) {
        // Make sure the admin user exists
        if(userService.findUserByLogin("admin").size() == 0 ) {
            User admin = new User("admin", "password", "", "", UserGender.MALE, "admin@jonrah.com", UserType.ADMIN);
            userService.addUser(admin);
        }

        // TODO validate this
        // Ensure all issueTypes are added to the database
        InputStream in = getClass().getClassLoader().getResourceAsStream("issuetypes.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String s: properties.stringPropertyNames()) {
            IssueType issueType = new IssueType(Long.valueOf(s), properties.getProperty(s));
            if(issueTypeService.findIssueByName(issueType.getName()).size() == 0) {
                issueTypeService.addIssueType(issueType);
                System.out.println("added issuetype " + issueType.getName());
            }
        }
    }
}
