package com.bt.user;

import com.bt.user.service.UserService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * User: Peter Johnston
 * Date: 12/16/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com.bt/applicationContext.xml" , "classpath:hibernate.cfg.xml"})
public class UserServiceImplTest {

    @Autowired
    UserService impl;

    @BeforeClass
    public static void setup() {

    }

    @Test
    public void testAddAndDeleteUser() {
        int size = impl.getUsers().size();
        User user = new User("first", "last", UserGender.MALE, "email", UserType.GENERIC);
        impl.addUser(user);
        assertEquals(size + 1, impl.getUsers().size());
        impl.deleteUser(user);
        assertEquals(size, impl.getUsers().size());
    }
}
