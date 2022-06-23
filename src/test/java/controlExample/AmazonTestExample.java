package controlExample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class AmazonTestExample {

	@Test
	public void searchTestCase() throws Exception {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\Act\\Downloads\\chromedriver_win32_June_14\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

	
		
		
		
		
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15");
		driver.findElement(By.id("nav-search-submit-button")).click();

		
		Thread.sleep(4000);
		//close browser
		//driver.quit();
		driver.close();
	}

}
