package frameExample;

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

public class PayTMApplication  {

	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://paytm.com/");

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();

	}
	
	@Test
	public void PromptAlert() throws Exception {

		WebElement btnSignIN = driver.findElement(By.xpath("//span[text()='Sign In']"));
		btnSignIN.click();
		
		
		//handle frame
		//driver.switchTo().frame(0);		//indexing start from 0
		//driver.switchTo().frame("name/id");
		
		
		
		//WebElement
		WebElement myFrame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(myFrame);
		
		
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".heading")));
		
		
		String headingFrame = driver.findElement(By.cssSelector(".heading")).getText();
		System.out.println(headingFrame);
		Assert.assertTrue(headingFrame.contains("your Paytm Web"));
		
		
		WebElement watchVideo = driver.findElement(By.xpath("//span[contains(text(),'Watch V')]"));
		watchVideo.click();
		
		
		
		
	}

}
