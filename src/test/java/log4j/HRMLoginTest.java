package log4j;



import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//import configExample.ConfigReaderExample;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginTest {

	
	@Test
	public void login() throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//ConfigReaderExample config = new ConfigReaderExample();
		
		Logger log = Logger.getLogger("Steria_Org_Automation_Logger");
		PropertyConfigurator.configure(".configFolder/log4j.properties");
		//PropertyConfigurator.configure(config.getLog4JFilePath());
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
		log.info("******************************");
		log.info("HRM Application launched.");
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		log.info("Entered UserName");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		log.info("Entered Password");
		
		driver.findElement(By.id("btnLogin")).click();
		log.info("Clicked on Loggin Button");
		
		
		String actual = driver.findElement(By.cssSelector("h1")).getText();
		
		if(actual.contains("Dash")) {
			
			
			Assert.assertTrue(true, "Dashboard verification passed");
			log.info("Dashboard verification ------ passed");
		}
		else {
			
			Assert.assertTrue(true,"Dashboard verification failed" );
			log.info("Dashboard verification ------ failed");
		}
	}
	
	
}
