package com.jonrah.user;

import com.jonrah.user.service.UserService;
import javassist.NotFoundException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * User: Peter Johnston
 * Date: 12/16/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/jonrah/applicationContext.xml" , "classpath:com/jonrah/applicationContext-jpa.xml"})
public class UserServiceImplTest {

    @Autowired
    UserService impl;

    private String userName = "user";
    private String password = "password";
    private String firstName = "first";
    private String lastName = "last";
    private String email = "email";

    @BeforeClass
    public static void setup() {}

    /**
     * Tests the add, update, remove and restore by id methods of the UserService
     * @throws NotFoundException
     */
    @Test
    public void testAddAndDeleteUser() throws NotFoundException {

        // Get the original amount of Users in the database
        int size = impl.findAllUsers().size();
        User user = createUser();

        // If the user already exists lets not try to add them again
        if( impl.findUserByLogin(user.getUserName()).size() == 0 ) {
            // Add the new user
            impl.addUser(user);
            // Check the amount of Users now includes our added User
            assertEquals(size + 1, impl.findAllUsers().size());

        }
        String newFirstName = "blahblah";
        // Change the users first name
        user.setFirstName(newFirstName);
        // Update the user to include the new first name
        impl.updateUser(user);

        long id = user.getId();
        // Retrieve the updated user
        User updatedUser = impl.restoreUserById(id);
        // Make sure the change in first name is reflected
        assertEquals(newFirstName, updatedUser.getFirstName());
        // Check that the user type was set automatically to GENERIC
        assertEquals(UserType.GENERIC, updatedUser.getUserType());

        // Finally remove the user to complete the test
        impl.removeUser(user);
        // And make sure the amount of users has returned back to where it started
        assertEquals(size, impl.findAllUsers().size());
    }

    /**
     * Test the remove by User Id method throws the correct exception
     * @throws NotFoundException
     */
    @Test(expected = NotFoundException.class)
    public void testRemoveNFE() throws NotFoundException{
        try {
            impl.removeUserById(-1);
        } catch(NotFoundException nfe) {
            if(!nfe.getLocalizedMessage().equals("A user with this id does not exist")) {
                fail();
            } else {
                throw new NotFoundException("Not Found Exception");
            }
        }
    }

    /**
     * Creates a user for testing
     * @return
     */
    private User createUser() {
        return new User(userName, password, firstName, lastName, UserGender.MALE, email);
    }
}
