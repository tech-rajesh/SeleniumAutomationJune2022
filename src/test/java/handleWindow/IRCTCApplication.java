package handleWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IRCTCApplication {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/nget/train-search");

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		// driver.close(); // close focus window
		driver.quit();

	}

	@Test
	public void handleWindow() throws Exception {

		//
		String parentWindow = driver.getWindowHandle();
		System.out.println("parentWindow" + parentWindow);

		// Model -----
		WebElement btn_OK = driver.findElement(By.xpath("//button[contains(text(),'K')]"));
		btn_OK.click();

		Thread.sleep(2000);
		// Click on
		WebElement lnk_HOTEL = driver.findElement(By.xpath("//a[contains(text(),'HOTELS')]"));
		lnk_HOTEL.click();

		Thread.sleep(3000);
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		// Click on
		WebElement lnk_Flight = driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]"));
		
		JS.executeScript("arguments[0].click()", lnk_Flight);
		//lnk_Flight.click();

		
		
		Thread.sleep(2000);
		// multiple window

		Set<String> multipleWindow = driver.getWindowHandles();
		String mainIRCTCWindow = (String) multipleWindow.toArray()[0];
		String HotelWindow = (String) multipleWindow.toArray()[2];
		String flightWindow = (String) multipleWindow.toArray()[1];

		System.out.println("mainIRCTCWindow: " + mainIRCTCWindow); // unique value - window ID
		System.out.println("HotelWindow: " + HotelWindow); // unique value - window ID
		System.out.println("FlightWindow: " + flightWindow);
		// SwitchTo Hotel Window
		Thread.sleep(5000);
		driver.switchTo().window(HotelWindow);
		
		WebElement ele_login = driver.findElement(By.linkText("Login"));
		
		JS.executeScript("arguments[0].click()", ele_login);
		
		//driver.findElement(By.linkText("Login")).click();

		Thread.sleep(5000);

		driver.switchTo().window(parentWindow);
		// Switch to main/parent window
		WebElement lnk_ContactUS = driver.findElement(By.xpath("//a[contains(text(),'CONTACT US')]"));
		lnk_ContactUS.click();

		// SwitchTo Hotel Window
		Thread.sleep(5000);
		driver.switchTo().window(HotelWindow);
		driver.findElement(By.xpath("//input[@type=\"password\"]//ancestor::form//descendant::button")).click();

		Thread.sleep(5000);
		driver.switchTo().window(flightWindow);

	}

}
