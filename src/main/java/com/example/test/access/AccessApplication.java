package com.example.test.access;

import net.ucanaccess.converters.FunctionsAggregate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class AccessApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(AccessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.update("INSERT INTO employees(city, street) VALUES ('Chennai', 'first')");
		template.update("INSERT INTO employees(city, street) VALUES ('Banglore', 'second')");
		template.update("INSERT INTO employees(city, street) VALUES ('Mumbai', 'third')");

		List<Employees> emplist = template.query("SELECT city, street FROM employees", new RowMapper<Employees>() {

			@Override
			public Employees mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Employees(rs.getString("city"), rs.getString("street"));
			}
		});

		emplist.forEach(System.out::println);
	}
}
