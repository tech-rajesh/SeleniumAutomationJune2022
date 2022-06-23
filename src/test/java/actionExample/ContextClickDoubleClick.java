package actionExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickDoubleClick  {

	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();

	}
	
	@Test
	public void contextClicktest() throws Exception {

		WebElement btn_RightClick = driver.findElement(By.cssSelector(""));
		
		Actions act = new Actions(driver);
		//App1
		act.contextClick(btn_RightClick).perform();
		
		
		WebElement btn_Delete = driver.findElement(By.cssSelector(""));
		btn_Delete.click();
		
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText);
		Assert.assertTrue(alertText.contains("delete"));
		driver.switchTo().alert().accept();
		
		
	}

}
