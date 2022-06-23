package grid;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HRMLoginTestGrdiSetup {

	public WebDriver driver;
	
	
	@BeforeTest
	public void setup() throws IOException {
		
		String nodeURL = "http://localhost:5566/wd/hub";
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		
		
		driver = new RemoteWebDriver(new URL(nodeURL), cap);
		
	}
			
	@AfterTest
	public void teardown() {
		
		driver.quit();
		
		
	}
	
	@Test
	public void login() throws Exception {
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		
		Thread.sleep(4000);
		driver.findElement(By.id("welcome")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
		
		driver.findElement(By.linkText("Logout")).click();
		
		Thread.sleep(4000);
		
				
		
	}
	
	
}
