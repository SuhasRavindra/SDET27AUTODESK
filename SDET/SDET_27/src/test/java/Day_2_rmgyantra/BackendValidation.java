package Day_2_rmgyantra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class BackendValidation {
	public static void main(String[] args) throws Throwable {
		Connection connection=null;
		try{ 
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into project values('TY_Project_125','mohangowda3','16/12/2021','Alined3','created','0');");
			ResultSet actualResult = statement.executeQuery("select * from project");
			String expectedResult="mohangowda";
			int count=0;
			while(actualResult.next())
			{
				if(actualResult.getString(2).equalsIgnoreCase(expectedResult))
				{count++;}
			}
			if (count==1)
			{
				System.out.println("IN BackEnd Data is Visible==>> Pass");
			}
			else {
				{
					System.out.println("IN BackEnd Data is not Visible==>> Fail");
				}
			}

		}
		catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			connection.close();

		}
	}
}
