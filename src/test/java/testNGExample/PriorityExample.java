package testNGExample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PriorityExample {

	
	//BeforeTest
	//login ---> addItems ----> payment ---> logout
	//AfterTest
	
	
	
	//Priority 
	//default priority : 0
	//priority - negative highest ----- highest priority 
	
	@BeforeTest
	public void launchApp() {
		
		System.out.println("Launch App");
	}
	
	@AfterTest
	public void closeApp() {
		
		System.out.println("closeApp App");
	}
	
	
	@Test(priority = -1)
	public void login() {
		System.out.println("Login test case");
		
	}
	
	
	@Test(priority = 2)
	public void logout() {
		System.out.println("Logout test case");
		
	}
	
	@Test(priority = 0)
	public void addItems() {
		System.out.println("addItems test case");
		
	}
	
	@Test(priority = 1)
	public void payment() {
		System.out.println("payment test case");
		
	}
	
	
}
