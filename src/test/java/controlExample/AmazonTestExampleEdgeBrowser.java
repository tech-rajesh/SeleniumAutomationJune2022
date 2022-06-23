package controlExample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class AmazonTestExampleEdgeBrowser {

	@Test
	public void searchTestCase() throws Exception {

		//cross browser Testing
		
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Act\\Downloads\\chromedriver_win32_June_14\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();

		//System.setProperty("","C:\\Users\\Act\\Downloads\\chromedriver_win32_June_14\\chromedriver.exe");
		
		System.setProperty("webdriver.edge.driver", ".\\SteriaDrivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		
		
		
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15");
		driver.findElement(By.id("nav-search-submit-button")).click();

		
		Thread.sleep(4000);
		//close browser
		//driver.quit();
		driver.close();
	}

}
