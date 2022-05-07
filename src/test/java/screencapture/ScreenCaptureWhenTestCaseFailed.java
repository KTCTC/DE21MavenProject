package screencapture;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ScreenCaptureWhenTestCaseFailed {
	WebDriver driver;
	
	@Test
	public void getScreenShotFromWebPage() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
		 driver = new  ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement inputFile = driver.findElement(By.id("uploadfile_0"));
		inputFile.sendKeys(System.getProperty("user.dir")+"\\DE21Prop.properties");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();	
		WebDriverWait wt = new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[@id='res']//center[contains(text(),'1 file ')]"))));				
		
		
		Assert.assertTrue(true);
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) 
	{
		if (result.getStatus()== ITestResult.SUCCESS)
		{
			System.out.println("Test case is passed so, not capturing screen shot");
		}
		
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			try {
				TakesScreenshot ts = (TakesScreenshot)driver;
				
				File f = ts.getScreenshotAs(OutputType.FILE);
				
				File actF = new File(System.getProperty("user.dir")+"\\"+result.getName()+".png");
				
				FileUtils.copyFile(f, actF);
			} catch (Exception e) {
				// TODO Auto-generated catch block				
			} 
		}
		else
		{
			System.out.println("Test case is skipped so, not capturing screen shot");
		}
		
		
	}
	
	

}
