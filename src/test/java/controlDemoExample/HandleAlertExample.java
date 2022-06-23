package controlDemoExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
		driver.manage().window().maximize();
		driver.get("http://www.uitestpractice.com/Students/Switchto");

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();

	}
	
	@Test
	public void PromptAlert() throws Exception {

		driver.findElement(By.xpath("//button[text()='Prompt']")).click();
		Thread.sleep(4000);
		
		String name = "Anil Kumar";
		
		Alert promptAlert = driver.switchTo().alert();
		Assert.assertTrue(promptAlert.getText().contains("Enter your name"));	
		System.out.println(promptAlert.getText());
		
		promptAlert.sendKeys(name);
		
		promptAlert.accept();
		
		
		//validation Step
		
		String actualText = driver.findElement(By.xpath("//div[@id='demo']")).getText();
		
		System.out.println(actualText);
		Assert.assertTrue(actualText.contains(name));
		

		
		
	}

}
