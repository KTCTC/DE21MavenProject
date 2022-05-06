package dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAnnotationForToolQA {
	WebDriver driver;
	@BeforeClass
	public void beforeClassMethod()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
		driver = new  ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/webtables");
	}
	
	
	@Test (dataProvider =  "UserDetails")
	public void addUserWithProvidedDetails(String name, String lname, String email, String age, String salary, String dept)
	{
		driver.findElement(By.id("addNewRecordButton")).click();
		
		driver.findElement(By.id("firstName")).sendKeys(name);
		driver.findElement(By.id("lastName")).sendKeys(lname);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("age")).sendKeys(age);
		driver.findElement(By.id("salary")).sendKeys(salary);
		driver.findElement(By.id("department")).sendKeys(dept);
		driver.findElement(By.id("submit")).click();
		
	}
	
	@DataProvider (name = "UserDetails")
	public String[][] getUserDetails()
	{
		String [][] arr = {{"Amar", "P", "amar@p.com","23","23456","IT"}, {"Amol", "G", "amol@g.com", "44", "56787","Finance"}};
		
		return arr;
		
	}
	
	
	

}
