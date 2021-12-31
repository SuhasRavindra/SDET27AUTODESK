package com.crm.autodesk.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * It contains DataBase Specific Reusable methods/actions
 * @author MOHANKUMAR GOWDA
 *
 */
public class DataBaseUtility {
	Connection connection;
	Statement statement;
	

	/**
	 * used to establish the Database connection
	 * @param databaseName
	 * @param username
	 * @param password
	 * @throws Throwable
	 */
	public void getDBConnection(String dburl, String databaseName, String username, String password) throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection(dburl+"/"+databaseName,username,password);
		statement = connection.createStatement();
		
	}
	
	/**
	 * Used to Close the DataBase Connection
	 * @throws Throwable
	 */
	public void closeDBConnection() throws Throwable {
		connection.close();	
	}
	
	/**
	 * Used to Fetch/read the set of data from database
	 * @param query
	 * @throws Throwable
	 */
	public ResultSet executeQuerry(String query) throws Throwable {

		ResultSet result = statement.executeQuery(query);
		return result;
	}
	
	
	/**
	 * Used to Modify the Data in Database
	 * @param query
	 * @throws Throwable
	 */
	public int updateQuerry(String query) throws Throwable {
		int status = statement.executeUpdate(query);
		return status;
	
	}
}
