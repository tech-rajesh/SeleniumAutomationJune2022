package takeScreesnhotExample;

import java.io.File;

import org.apache.commons.io.FileUtils;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestExample {

	@Test
	public void searchTestCase() throws Exception {

		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();

	
		
		
		
		
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15");
		driver.findElement(By.id("nav-search-submit-button")).click();

		
		Thread.sleep(4000);
		
		//take screenshot
//		
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		
//		ts.getScreenshotAs(OutputType.FILE);
		
		//lib ----- ashot ----- Jpeg
		
		
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		File targetLocation = new File("./screesnhot/AmazonSearchTest1.png");
		
		FileUtils.copyFile(screenshotFile, targetLocation);
		
		driver.close();
	}

}
