package webDriverManagerExample;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTestExampleEdgeBrowser {

	@Test
	public void searchTestCase() throws Exception {

		// drivers - compatiblity issue

		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();

		//WebDriverManager.edgedriver().setup();
		//WebDriver driver = new EdgeDriver();
		
		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 15");
		driver.findElement(By.id("nav-search-submit-button")).click();

		Thread.sleep(4000);
		// close browser
		// driver.quit();
		driver.close();
	}

}
