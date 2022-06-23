package hrmLoginTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import configReadExample.ReadDataFromPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowserBaseTest {

	WebDriver driver;
	ReadDataFromPropertyFile conf;

	
	@Parameters("browser")
	@BeforeTest
	public void launchApp(String browserInfo) throws Exception {
		
		
		//String browserInfo = "warawrqwe";
		
		if(browserInfo.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}
		
		
		
		
		System.out.println("BrowserDetails: " + browserInfo);
		
		
		driver.manage().window().maximize();
		
		
		conf = new ReadDataFromPropertyFile();
		driver.get(conf.getAppURL());

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();

	}

}
