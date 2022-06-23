package locatorExample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginTestLocator {

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
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
	}
	
	
	@Test
	public void login() throws Exception {
		
		System.out.println("login test case");
		
		//identification
		//findElement
		
		//Locator - ID
		
		WebElement txtUserName = driver.findElement(By.id("txtUsername"));
		
		//element present on page or not
		//clear text
		System.out.println("UserName is present on page or not: "+txtUserName.isDisplayed());
		Thread.sleep(2000);
		txtUserName.sendKeys("Admin12312312");
		Thread.sleep(2000);
		txtUserName.clear();
		
		Thread.sleep(2000);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		//Locator - Name
		//Password
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		//Locator - ClassName
		driver.findElement(By.className("button")).click(); //Login Button
		
		//Locator - partialLinkText
		driver.findElement(By.partialLinkText("Welcome")).click();
		
		Thread.sleep(4000);
		
		//Locator - LinkText
		driver.findElement(By.linkText("Logout")).click();
		
		
		//Forgot Password 
		//partial link text
		Thread.sleep(4000);
		driver.findElement(By.partialLinkText("your pass")).click();
		
		Thread.sleep(2000);
		//click on Cancel button
		driver.findElement(By.id("btnCancel")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("word?")).click();
		
		Thread.sleep(2000);
		//click on Cancel button
		driver.findElement(By.id("btnCancel")).click();
		
	}
	
	@After
	public void closeApp() throws Exception {
		System.out.println("Close the application");
		Thread.sleep(4000);
		driver.close();
	}
	
	
	
	
}
