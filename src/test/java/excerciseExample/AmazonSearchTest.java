package excerciseExample;

import org.junit.After;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
///import junit.framework.Assert;
import org.junit.Assert;

public class AmazonSearchTest {
	WebDriver driver;
	
	@Before
	public void launchApp() {
		//launch chrome browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		//launch app
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void searchItems() throws Exception {
		
		driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("iphone");
		driver.findElement(By.cssSelector("input[value=\"Go\"]")).click();
		
		Thread.sleep(2000);
		//get the application title
		String appURL = driver.getCurrentUrl();
		String pageSource = driver.getPageSource();
		String actualAppTitle = driver.getTitle();
		
		
		//validation
		//expected value with actual value
		System.out.println(actualAppTitle);
		System.out.println(appURL);
		
		
		Assert.assertEquals("Amazon.in : iphone", actualAppTitle);
		
		
	}
	
	@After
	public void closeApp() throws Exception {
		
		Thread.sleep(4000);
		driver.close();
	}
	
	
	
	
	

}
