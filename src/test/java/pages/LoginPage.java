package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver remotedriver) {

		this.driver = remotedriver;

	}

	// locator/Identification

	By txt_userName = By.name("txtUsername");
	By txt_password = By.cssSelector("input#txtPassword");
	By btn_Login = By.className("button");

	// Methods
	public void enterUserName(String user) {

		driver.findElement(txt_userName).sendKeys(user);
		
	}

	public void enterPassword(String pwd) {

		driver.findElement(txt_password).sendKeys(pwd);
		

	}

	public void click_LoginButton() {

		driver.findElement(btn_Login).click();

	}
	
	public void verifyAppTitle(String expectedTitle) {

		Assert.assertEquals(driver.getTitle(), expectedTitle);

	}

}
