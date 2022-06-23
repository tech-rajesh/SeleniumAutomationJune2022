package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage_PageFactory {

	WebDriver driver;

	public LoginPage_PageFactory(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

//	// locator/Identification
//
//	By txt_userName = By.name("txtUsername");
//	By txt_password = By.cssSelector("input#txtPassword");
//	By btn_Login = By.className("button");
	
	
	
	@FindBy(name = "txtUsername")
	WebElement txt_userName;
	
	@FindBy(css  = "input#txtPassword")
	WebElement txt_password;
	
	@FindBy(className =  "button")
	WebElement btnLogin;
	
	
	
	
	
	
	

	// Methods
	public void enterUserName(String user) {

		txt_userName.sendKeys(user);
		
	}

	public void enterPassword(String pwd) {

		txt_password.sendKeys(pwd);
		

	}

	public void click_LoginButton() {

		btnLogin.click();

	}
	
	public void verifyAppTitle(String expectedTitle) {

		Assert.assertEquals(driver.getTitle(), expectedTitle);

	}

}
