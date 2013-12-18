package com.bt.user;

import com.bt.user.service.UserService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * User: Peter Johnston
 * Date: 12/16/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/bt/applicationContext.xml" , "classpath:com/bt/applicationContext-jpa.xml"})
public class UserServiceImplTest {

    @Autowired
    UserService impl;

    @BeforeClass
    public static void setup() {

    }

    @Test
    public void testAddAndDeleteUser() {
        String firstName = "first";
        String lastName = "last";
        String email = "email";

        // Get the original amount of Users in the database
        int size = impl.getAllUsers().size();
        User user = new User(firstName, lastName, UserGender.MALE, email, UserType.GENERIC);
        // Add the new user
        impl.addUser(user);
        // Check the amount of Users now includes our added User
        assertEquals(size + 1, impl.getAllUsers().size());

        long id = user.getId();
        String newFirstName = "blahblah";
        // Change the users first name
        user.setFirstName(newFirstName);
        // Update the user to include the new first name
        impl.updateUser(user);

        // Retrieve the updated user
        User updatedUser = impl.findUserById(id);
        // Make sure the change in first name is reflected
        assertEquals(newFirstName, updatedUser.getFirstName());

        // Finally remove the user to complete the test
        impl.removeUser(user);
        // And make sure the amount of users has returned back to where it started
        assertEquals(size, impl.getAllUsers().size());
    }
}
