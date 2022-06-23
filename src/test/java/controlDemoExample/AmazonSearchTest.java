package controlDemoExample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AmazonSearchTest extends BaseTestAmazon{

	
	@Test
	public void testCase1() {
		
		//2 elements
		driver.findElements(By.className("nav-input")).get(0).sendKeys("iphone");
		driver.findElements(By.className("nav-input")).get(1).click();
		
	}
	
	
}
