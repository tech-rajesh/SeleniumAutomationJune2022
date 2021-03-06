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

public class HandleAlertExample  {

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
	public void PromptAlert() throws Exception {

		Thread.sleep(3000);
		WebElement myPrompt = driver.findElement(By.xpath("//button[text()='Prompt']"));
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		
		//JS.executeScript("alert('hello team, happy learning');");
		JS.executeScript("arguments[0].click();", myPrompt);

		
		driver.switchTo().alert().accept();
	}

}
