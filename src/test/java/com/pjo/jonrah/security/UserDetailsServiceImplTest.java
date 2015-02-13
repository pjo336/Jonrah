package com.pjo.jonrah.security;

import com.pjo.jonrah.user.User;
import com.pjo.jonrah.user.UserGender;
import com.pjo.jonrah.user.UserType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Peter Johnston on 12/21/13
 * Jonrah
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/pjo/jonrah/applicationContext.xml"})
public class UserDetailsServiceImplTest {

    private UserDetailsServiceImpl impl;

    private String userName = "user";
    private String password = "password";
    private String firstName = "first";
    private String lastName = "last";
    private String email = "email";

    @Before
    public void setup() {
        impl = new UserDetailsServiceImpl();
    }

    /**
     * Check the output
     */
    @Test
    public void testRole() {
        User user = createUser();
        System.out.println(impl.getRole(user));
    }

    /**
     * Creates a user for testing
     * @return
     */
    private User createUser() {
        return new User(userName, password, firstName, lastName, UserGender.MALE, email, UserType.GENERIC);
    }
}
