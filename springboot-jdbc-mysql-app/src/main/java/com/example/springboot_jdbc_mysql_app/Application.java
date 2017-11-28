package com.example.springboot_jdbc_mysql_app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/* project was created from start.spring.io using only the JDBC and MySql options under the SQL section */

/* implementing the CommandLineRunner causes the run method to automatically run after Spring has loaded */
@SpringBootApplication
public class Application implements CommandLineRunner {

    // using a logger gives a lot more contextual information along with the output
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }

    /*
     * the spring-boot-starter-jdbc allows Spring to automatically generate the
     * jdbcTemplate bean. It will default to a tomcat-jdbc datasource container and
     * the settings found in the application.properties file.
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
	/*
	 * all code from here down is not configuration; it's just testing out the
	 * database connection. To see the database script, look in the top-level
	 * project folder.
	 */
	List<String> hatNames = Arrays.asList("cowboy hat", "crown", "baseball cap");
	log.info("Inserting data...");
	hatNames.forEach(hatName -> {
	    jdbcTemplate.update("INSERT INTO hat (hatname) VALUES (?)", hatName);
	});
	log.info("Retrieving data...");
	List<Hat> hats = jdbcTemplate.query("SELECT * FROM hat", new HatMapper());
	log.info("hats in database:");
	hats.forEach(hat -> {
	    log.info(hat.getHatname());
	});

    }

    private static final class HatMapper implements RowMapper<Hat> {
	@Override
	public Hat mapRow(ResultSet rs, int i) throws SQLException {
	    Hat hat = new Hat(rs.getLong("id"), rs.getString("hatname"));
	    return hat;
	}
    }
}
