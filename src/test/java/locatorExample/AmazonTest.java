package locatorExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	//Unit Testing Framework
	//pre-condition -- @Before
	//Test
	//post-condition -- @After
	//ctrl+Shoift+O - auto import
	
	WebDriver driver;
	
	
	@Before
	public void launchApp() {
		System.out.println("launch chrome browser and open App - HRM");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		//launch app
		driver.get("https://www.amazon.in/");
		
	}
	
	
	@Test
	public void login() throws Exception {
		
		System.out.println("login test case");
		
		//identification
		//findElement
		
		//Locator - ID
		
		WebElement txtUserName = driver.findElement(By.className("nav-input"));	// 2 matches 
		
		txtUserName.sendKeys("iphone");
		
		
		
	}
	
	@After
	public void closeApp() throws Exception {
		System.out.println("Close the application");
		Thread.sleep(4000);
		driver.close();
	}
	
	
	
	
}
