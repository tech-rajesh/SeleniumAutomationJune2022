package grid;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginTestGrdiSetup_ChromeBrowser {

	public WebDriver driver;
	
	
	@BeforeTest
	public void setup() throws IOException {
		
		String nodeURL = "http://localhost:5566/wd/hub";
		DesiredCapabilities cap = new DesiredCapabilities().chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		//System.setProperty("webdriver.chrome.driver", "D:\\Jar_files\\UpdatedFolder\\grid_setup\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
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
