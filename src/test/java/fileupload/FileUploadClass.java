package fileupload;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadClass {

	public static void main(String[] args) {
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
		String txt = driver.findElement(By.xpath("//h3[@id='res']//center[contains(text(),'1 file ')]")).getText();
		txt = txt.replace("\n", " ");
		
		
		if (txt.equals("1 file has been successfully uploaded."))
		{
			System.out.println("File upload test case is passed");
		}
		else
		{
			System.out.println("File upload test case is failed");
		}
		
		
	}

}
