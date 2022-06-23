package hrmLoginTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configReadExample.ReadDataFromPropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginApplication extends CrossBrowserBaseTest{

	
	
	@Test
	public void loginTest() throws Exception {
		
		driver.findElement(By.name("txtUsername")).sendKeys(conf.getAdminUser());
		driver.findElement(By.name("txtPassword")).sendKeys(conf.getPasword());
		
		driver.findElement(By.name("Submit")).click();
		
		
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//a[contains(@id,'menu_admin_viewAdminModule')]")).click();
		
		System.out.println(driver.getCurrentUrl());
	}

}
