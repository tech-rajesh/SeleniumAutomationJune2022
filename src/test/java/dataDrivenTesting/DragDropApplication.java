package dataDrivenTesting;

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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDropApplication  {

	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();

	}
	
	@Test(dataProvider = "regressionTest")
	public void DataDrivenTest(String userName, String password) throws Exception {

		Thread.sleep(4000);
		//wrong credentials
		driver.findElement(By.name("txtUsername")).clear();
		driver.findElement(By.name("txtUsername")).sendKeys(userName);
		driver.findElement(By.name("txtPassword")).clear();
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
		
		Thread.sleep(4000);
		
		//validation Step
		Boolean usernameCannotBe = driver.findElement(By.cssSelector("span#spanMessage")).isDisplayed();
		Assert.assertTrue(usernameCannotBe);
		
	}
	
	@DataProvider
	public Object[][] smokeTest() {
		
		//taking data from excel/csv/database
		
		//sheet1
		Object [][] data = { {"jyoti", "124321342"}, {"chirag", "welcome@123"} ,  {"Rishab", "welcome@123"}};
		return data;
	}
	
	@DataProvider
	public Object[][] regressionTest() {
	
		//sheet2 - 100K records
		//taking data from excel/csv/database
		Object [][] data = { {"jyotiregression", "124321342"}, {"chiragresgression", "welcome@123"} ,  {"Rishabregression", "welcome@123"}};
		return data;
	}

}
