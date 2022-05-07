package brockenlinks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PrintAllLinksStatusCode {
	
	
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
			
			if (actURL!=null)
			{
			
			if(actURL.contains("javascript:void(0)"))
			{
				actURL = baseURL+each.getAttribute("id");
			}
			
			printLinkResponseCodeAndResponceMessage(actURL);
			}
		}
		
	}
	
	
	public static void printLinkResponseCodeAndResponceMessage(String link) 
	{
		HttpsURLConnection http = null;
		try {
			URL url = new URL(link);
			URLConnection con = url.openConnection();
			http = (HttpsURLConnection) con;
			http.setConnectTimeout(15000);

			http.connect();	

		int code = http.getResponseCode();

		String msg = http.getResponseMessage();

		System.out.println(link);
		System.out.println("Response code = "+code+" Response Message = "+msg);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
