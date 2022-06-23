package locatorExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchTest {

	WebDriver driver;
	
	@Before
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//launch app
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void Searchtest() {
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15");
		driver.findElement(By.id("nav-search-submit-button")).click();
		
	}
	
	@After
	public void closeApp() throws Exception {
		
		Thread.sleep(4000);
		driver.close();
		
	}
	
}
