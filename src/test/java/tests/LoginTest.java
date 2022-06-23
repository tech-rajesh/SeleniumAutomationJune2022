package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseTest {

	
	@Test
	public void login()  {

		lp.enterUserName(conf.getAdminUserName());
		lp.enterPassword(conf.getPassword());
		lp.click_LoginButton();
		
		//validation step
		lp.verifyAppTitle("OrangeHRM");
		
		
	}
	
	@Test
	public void verifydashBoard() {
		
		System.out.println("verification of dashboard");
	}

}
