package Day_2_rmgyantra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class VerifyProjectName {
	public static void main(String[] args) throws Throwable {
		int Guicount=0;
		int Backendcount=0;
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		String expectedResult="Lara_Classified";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
		driver.get("http://localhost:8084/");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("Lara_Classified");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Mr. Adarsh");
		WebElement dropdown = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
		Select select=new Select(dropdown);
		select.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		List<WebElement> rows = driver.findElements(By.xpath("//td[2]"));

		for (int i=0; i<rows.size(); i++)
		{
			String projectName = rows.get(i).getText();
			//System.out.println(projectName);
			if (projectName.equals(expectedResult))
			{
				Guicount++;
			}
		}
		if(Guicount==1)
		{
			System.out.println("IN FrontEnd Data is Visible ===> PASS");
		}
		else {
			System.out.println("IN FrontEnd Data is not Visible ===> FAIL");
		}

		Thread.sleep(5000);

		driver.quit();


		Connection connection=null;
		try {
			Driver d = new Driver();
			DriverManager.registerDriver(d);

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");

			Statement statement = connection.createStatement();
			String query="select * from project";

			ResultSet result=statement.executeQuery(query);

			while(result.next())
			{
				if(expectedResult.equals(result.getString(4))) 
				{
					Backendcount++;
				}
			}
			if(Backendcount==1)
			{
				System.out.println("IN BackEnd Data Visible==>> PASS");
			}
			else {
				{
					System.out.println("IN BackEnd Data is not Visible==>> FAIL");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			//Step 5- Close the Database Connection
			connection.close();
		}
	}

}
