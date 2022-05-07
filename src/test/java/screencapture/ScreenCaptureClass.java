package screencapture;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ScreenCaptureClass {
	
	
	@Test
	public void getScreenShotFromWebPage() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
		WebDriver driver = new  ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement inputFile = driver.findElement(By.id("uploadfile_0"));
		inputFile.sendKeys(System.getProperty("user.dir")+"\\DE21Prop.properties");
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();	
		WebDriverWait wt = new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[@id='res']//center[contains(text(),'1 file ')]"))));
				
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File f = ts.getScreenshotAs(OutputType.FILE);
		
		File actF = new File(System.getProperty("user.dir")+"\\abcd.png");
		
		FileUtils.copyFile(f, actF);
		
		
		
	}

}
