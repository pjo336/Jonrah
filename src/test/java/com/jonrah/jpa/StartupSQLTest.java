package com.jonrah.jpa;

import java.io.IOException;
import java.io.InputStream;
import java.lang.StringBuilder;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pjo336 on 12/18/13
 * biggertime
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/com/jonrah/applicationContext.xml" , "classpath:com/jonrah/applicationContext-jpa.xml"})
public class StartupSQLTest {

    private final static String droptable =
            "DROP TABLE IF EXISTS USER;";

    private final static String createTable = "create table USER ( " +
            "id bigint(11) not null auto_increment, " +
            "first_name varchar(45) default null, " +
            "last_name varchar(45) default null, " +
            "gender int(1) default null, " +
            "email varchar(60) not null, " +
            "user_type int(2) not null, " +
            "primary key (id) " +
            ");";

    private final static String addPeter = "insert into User(first_name, last_name, gender, email, user_type) " +
            "values(\"Peter\", \"Johnston\", 0, \"pjohnston@biggertime.com\", 0);";
    private final static String addDavid = "insert into User(first_name, last_name, gender, email, user_type) " +
            "values(\"David\", \"Hara\", 0, \"dhara@biggertime.com\", 0);";

    /**
     * This Builder will hold each line of Sql to be executed, followed by a line.separator
     * Once each query is added as a separate line, the builder is broken up into an array of Strings
     * This array is iterated over, and each query is run
     */
    private static StringBuilder builder = new StringBuilder();

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Add each query to its own line in the builder
     */
    @BeforeClass
    public static void setup() {
        builder.append(droptable);
        builder.append(System.getProperty("line.separator"));
        builder.append(createTable);
        builder.append(System.getProperty("line.separator"));
        builder.append(addPeter);
        builder.append(System.getProperty("line.separator"));
        builder.append(addDavid);
        builder.append(System.getProperty("line.separator"));
    }

    /**
     * Splits the builder into a string array for each line (query) and executes each query
     */
    @Test
    public void executeSqlScript() {
        String[] lines = builder.toString().split("\\n");
        for(String s: lines){
            jdbcTemplate.execute(s);
        }
        // Test that executing comments is no big deal
        jdbcTemplate.execute("#blahblahcomment");
    }

    /**
     * Currently ignored due to not being able to sort the properties correctly causing errors
     *
     * Since well be storing the database queries in a properties file, well test that we
     * can correctly pull them into our java file and thus will probably not need a string
     * builder.
     * @throws IOException
     */
    @Ignore
    @Test
    public void executeSqlFromPropertiesFile() throws IOException{
        InputStream in = getClass().getClassLoader().getResourceAsStream("sql.properties");
        Properties properties = new Properties();
        properties.load(in);
        Iterator<String> names = properties.stringPropertyNames().iterator();
        while(names.hasNext()) {
            System.out.println(names.next());
            names.remove();
        }

        for(Object s: properties.values()) {
            String query = s.toString();
            System.out.println(query);
            jdbcTemplate.execute(query);
        }
    }
}