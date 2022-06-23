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

public class DragDropApplication2  {

	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();

	}
	
	@Test
	public void dragDropTest() throws Exception {

		//concept missing
		//handle frame
		
		WebElement myFrame = driver.findElement(By.xpath("//iframe[contains(@data-src,'photo-manager')]"));
		driver.switchTo().frame(myFrame);
		
		
		WebElement img3 = driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));
		WebElement img4 = driver.findElement(By.xpath("//img[contains(@src,'tatras4')]"));
		WebElement target = driver.findElement(By.cssSelector("div#trash"));
		
		
		
		Actions act = new Actions(driver);
		//App1
		act.dragAndDrop(img3, target).perform();
		act.dragAndDrop(img4, target).perform();
		
		//app2
		//A convenience method that performs click-and-hold at the location of the source element, 
		//moves to the location of the target element, then releases the mouse.
		//act.clickAndHold(img3).moveToElement(target).release().build().perform();
		
		
		
		
	}

}
