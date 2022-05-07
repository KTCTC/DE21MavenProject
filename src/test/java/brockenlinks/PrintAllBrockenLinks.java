package brockenlinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintAllBrockenLinks {
	
	
	@Test
	public void getAllLinksStatusCode()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");		
		WebDriver driver = new  ChromeDriver();	
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/links");		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		String baseURL = "https://demoqa.com/";
		
		for (WebElement each:allLinks)
		{
			String actURL = each.getAttribute("href");
			
			if(actURL!=null && actURL.contains("javascript:void(0)"))
			{
				actURL = baseURL+each.getAttribute("id");
			}
			
			System.out.println(actURL);
		}
		
	}

}
