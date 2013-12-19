package com.jonrah.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pjo336 on 12/18/13
 * biggertime
 */
@ContextConfiguration(locations = {"classpath:com/jonrah/applicationContext-jpa.xml"})
public class StartupSQL {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Method will iterate over all the queries in the sql.properties file and execute them
     */
    public void executeSqlScript() {
        InputStream in = getClass().getClassLoader().getResourceAsStream("sql.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException ioe) {
            System.out.println("Cannot find properties file");
        }
    }
}
