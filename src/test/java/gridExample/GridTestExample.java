package gridExample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import configReadExample.ReadDataFromPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GridTestExample {

	RemoteWebDriver driver;
	String nodeURL;
	DesiredCapabilities cap;
	
	
	@Parameters("OS")
	@BeforeTest
	public void launchApp(String os) throws Exception {

		//String browser = "chrome";
		if(os.equalsIgnoreCase("WIN"))
		{
			nodeURL = "http://192.168.1.5:5577/wd/hub";
			cap = new DesiredCapabilities().chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			WebDriverManager.chromedriver().setup();
			
		}
		
		else if(os.equalsIgnoreCase("MAC")){
			
			nodeURL = "http://192.168.1.5:5566/wd/hub";
			cap = new DesiredCapabilities().chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			WebDriverManager.chromedriver().setup();
			
		}
		else {
			
			nodeURL = "http://192.168.1.5:5588/wd/hub";
			cap = new DesiredCapabilities().chrome();
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WINDOWS);
			WebDriverManager.chromedriver().setup();
			
		}
		
		driver = new RemoteWebDriver(new URL(nodeURL), cap);
		
//		ReadDataFromPropertyFile conf = new ReadDataFromPropertyFile();
//		System.out.println(conf.getAppURL());
		
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.quit();
		
	}

	@Test
	public void login() throws Exception {
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.name("Submit")).click();

	}

}
