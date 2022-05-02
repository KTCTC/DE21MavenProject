package fileupload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadClassRobotClass {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		WebElement inputFile = driver.findElement(By.id("uploadfile_0"));

		StringSelection stringSelection = new StringSelection(System.getProperty("user.dir") + "\\DE21Prop.properties");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Actions act = new Actions(driver);
		act.moveToElement(inputFile).click().build().perform();

		Thread.sleep(5000);

		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);

		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);

		Thread.sleep(5000);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("submitbutton")).click();

		WebDriverWait wt = new WebDriverWait(driver, 5);
		wt.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//h3[@id='res']//center[contains(text(),'1 file ')]"))));
		String txt = driver.findElement(By.xpath("//h3[@id='res']//center[contains(text(),'1 file ')]")).getText();
		txt = txt.replace("\n", " ");

		if (txt.equals("1 file has been successfully uploaded.")) {
			System.out.println("File upload test case is passed");
		} else {
			System.out.println("File upload test case is failed");
		}

	}

}
