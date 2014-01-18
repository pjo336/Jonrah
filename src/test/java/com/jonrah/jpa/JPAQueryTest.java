package com.jonrah.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertTrue;

/**
 * Created by Peter Johnston on 1/17/14
 * Jonrah
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/jonrah/applicationContext.xml" , "classpath:com/jonrah/applicationContext-jpa.xml"})
public class JPAQueryTest {

    @Autowired
    JPAQuery impl;

    @Test
    public void testCreateSelectStatement() {
        List<String> test = new ArrayList<String>();
        test.add("*");
        String select = impl.createSelectStatement(test);
        String hopefulResult = "SELECT *";
        assertTrue(select.equalsIgnoreCase(hopefulResult));
    }

    @Test
    public void testCreateSelectStatementMultiple() {
        List<String> test = new ArrayList<String>();
        test.add("derp");
        test.add("herp");
        test.add("merp");
        test.add("lerp");
        String select = impl.createSelectStatement(test);
        String hopefulResult = "SELECT derp, herp, merp, lerp";
        assertTrue(select.equalsIgnoreCase(hopefulResult));
    }

    @Test
    public void testCreateSelectAndFromStatementMultiple() {
        List<String> testSelect = new ArrayList<String>();
        testSelect.add("id");
        testSelect.add("user_name");
        testSelect.add("email");
        testSelect.add("gender");
        List<String> testFrom = new ArrayList<String>();
        testFrom.add("Jonrah_User");
        String query = impl.createFromStatement(impl.createSelectStatement(testSelect), testFrom);
        String hopefulResult = "select id, user_name, email, gender from jonrah_user";
        System.out.println(query);
        assertTrue(query.equalsIgnoreCase(hopefulResult));
    }
}
