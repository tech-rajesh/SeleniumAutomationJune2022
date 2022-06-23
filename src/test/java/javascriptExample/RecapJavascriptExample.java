package javascriptExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RecapJavascriptExample {

	
WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://www.uitestpractice.com/Students/Switchto");

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();

	}
	
	@Test
	public void handlePrompt() throws Exception {
		
		WebElement btn_prompt = driver.findElement(By.cssSelector("button#prompt"));
		
		
		//handle alert
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("arguments[0].click()", btn_prompt);
		
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
	}
}
