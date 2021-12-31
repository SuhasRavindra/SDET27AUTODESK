package Day_1_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDataBase {

	public static void main(String[] args) throws Throwable {
		//Step 1- Register/Load the MySQL Database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		//Step 2- Get connect to Database/Establish the connection with Database
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//Step 3- Create SQL Statement
	     Statement statement = connection.createStatement();
	     String query="select * from student_info";
		
		//Step 4- Execute Statement/Query
	     ResultSet result=statement.executeQuery(query);
	     
	     while(result.next())
	     {
	    	 System.out.println(result.getInt(1)+"\t"+result.getString(2));
	     }
		//Step 5- Close the Database Connection
	     connection.close();
	}

}
