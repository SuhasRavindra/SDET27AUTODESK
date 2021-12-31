package Day_1_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyTheDataIntoDatabase {
	public static void main(String[] args) throws Throwable {
		//Declaration
		Connection connection=null;
		System.out.println("mains start");
		try{ 
		//register the driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		//establish the connection
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		//create statement
		Statement statement = connection.createStatement();
		//execute query
		int result = statement.executeUpdate("insert into student_info (fname,lastname,address) values('harsha1','Gowda1','Bangalore1');");
		//int result1 = statement.executeUpdate("create table employee(id int not null auto_increment, fname varchar(20) not null, lname varchar(20) not null, phonenumber int(10) unique not null,primary key(id) );");
		int result2 = statement.executeUpdate("delete from student_info order by id asc limit 1");
		System.out.println("Try block got Exceuted");
		}
		catch (Exception e) {
		e.printStackTrace();
		}

		finally {
			//close the connection
			connection.close();
			System.out.println("Finaly block got executed");
		}
	}

}
