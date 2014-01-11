package com.jonrah.jpa;

import com.jonrah.trustt.type.IssueType;
import com.jonrah.trustt.type.IssueTypes;
import com.jonrah.trustt.type.service.IssueTypeService;
import com.jonrah.user.User;
import com.jonrah.user.UserGender;
import com.jonrah.user.UserType;
import com.jonrah.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by pjo336 on 1/11/14
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
            User admin = new User("admin", "password", "", "", UserGender.MALE, "admin@biggertime.com", UserType.ADMIN);
            userService.addUser(admin);
        }

        // TODO validate this
        // Ensure all issueTypes are added to the database
        for(IssueTypes type: IssueTypes.values()) {
            if(issueTypeService.findIssueByName(type.getIssueTypeName()).size() == 0 ) {
                IssueType issueType = new IssueType(type.getIssueTypeName());
                issueTypeService.addIssueType(issueType);
            }
        }
    }
}
