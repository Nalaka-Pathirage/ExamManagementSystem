package com.exam.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtility {

	private Properties properties;

	public DbUtility() {
		this.properties = doLoadProperties();
	}

	// for retrieving database connection instance
	public Connection doGetDbConnection() throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		return DriverManager.getConnection(properties.getProperty("database.url"),
				properties.getProperty("database.user"), properties.getProperty("database.password"));
	}

	// load configurations from property file
	private Properties doLoadProperties() {

		Properties properties = new Properties();

		/*
		 * try (InputStream input = new FileInputStream("application.properties")) {
		 * 
		 * prop.load(input);
		 * 
		 * System.out.println(prop.getProperty("database.url"));
		 * 
		 * } catch (IOException ex) { ex.printStackTrace(); }
		 */

		properties.setProperty("database.url", "jdbc:mysql://localhost:3306/exam_management_schema?useSSL=false");
		properties.setProperty("database.user", "");
		properties.setProperty("database.password", "");

		return properties;
	}
}
