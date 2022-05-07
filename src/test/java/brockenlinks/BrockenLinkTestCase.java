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
import org.testng.asserts.SoftAssert;

public class BrockenLinkTestCase {
	
	
	@Test
	public void getAllLinksStatusCode() throws IOException
	{
		SoftAssert sAssert = new SoftAssert();
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
			
			HttpsURLConnection http = printLinkResponseCodeAndResponceMessage(actURL);
			
			if (http.getResponseCode()>=400)
			{
				sAssert.assertTrue(false, actURL + " is broken with status code = "+http.getResponseCode()+" And response message = "+http.getResponseMessage());
			}
			
			}
		}
		
		sAssert.assertAll();
		
	}
	
	
	public static HttpsURLConnection printLinkResponseCodeAndResponceMessage(String link) 
	{
		HttpsURLConnection http = null;
		try {
			URL url = new URL(link);
			URLConnection con = url.openConnection();
			http = (HttpsURLConnection) con;
			http.setConnectTimeout(15000);
			http.connect();	
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return http;

	}

}
