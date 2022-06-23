package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import log4j.ReadConfigFile;
import pages.LoginPage;
import pages.LoginPage_PageFactory;

public class BaseTest {

	
	WebDriver driver;
	ReadConfigFile conf;
	//LoginPage lp ;
	LoginPage_PageFactory lp;

	@BeforeTest
	public void launchApp() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		conf = new ReadConfigFile();
		//lp = new LoginPage(driver);
		
		lp = new LoginPage_PageFactory(driver);
		
		
		
		//conf.getAppURL();
		driver.get(conf.getAppURL());

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();

	}

}
