package grid;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;

public class TestNG_GridSetupSimpleTest {
	public WebDriver driver;
	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	@BeforeTest
	public void launchapp() throws MalformedURLException {
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		String Node = "http://192.168.1.24:5588/wd/hub";
		
		driver = new RemoteWebDriver(new URL(Node), cap);
		

	}

	@Test
	public void organgeHRMLoginTest() throws Exception {

		driver.navigate().to("https://opensource-demo.orangehrmlive.com");
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");

	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}