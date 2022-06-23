package controlDemoExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleAlert extends BaseTest {

	//@Test
	public void SimpleAlert() throws Exception {

		//generate an alert
		driver.findElement(By.xpath("//input[contains(@value,'Show Me Alert')]")).click();

		Thread.sleep(4000);
		
		//handle alert
		
		//accept 	--- OK
		//dismiss 	--- cancel button
		//getText 	---
		//sendKeys 	---
		
		//Alert/window/frame ---- driver.switchTo()
		
		
		Alert simpleAlert = driver.switchTo().alert();
		
		
		String alertText = simpleAlert.getText();
		System.out.println("Alert Text : " + alertText);
		Assert.assertTrue(alertText.contains("alert message"));
		simpleAlert.accept();
		
		
		
		
	}

	
	//@Test
	public void ConfirmAlert() throws Exception {

		//generate an alert
		driver.findElement(By.xpath("//button[text()='Show Me Confirmation']")).click();
		Thread.sleep(4000);

		//handle alert
		//getText
		//cancel - dismiss
		//ok - accept
		//validate
		
				
		Alert confirmAlert = driver.switchTo().alert();
		Assert.assertTrue(confirmAlert.getText().contains("Press 'OK' or 'Cancel' button!"));	
		System.out.println(confirmAlert.getText());
		//confirmAlert.accept();
		confirmAlert.dismiss();
		//confirmAlert.sendKeys("");
		
		Thread.sleep(2000);
		//validate 
		String actualValidationText = driver.findElement(By.cssSelector("div[id='demo']")).getText();
		System.out.println(actualValidationText);
		//Assert.assertTrue(actualValidationText.contains("OK"));
		Assert.assertTrue(actualValidationText.contains("Cancel"));
		
	}
	
	
	@Test
	public void PromptAlert() throws Exception {

		driver.findElement(By.xpath("//button[text()='Show Me Prompt']")).click();
		Thread.sleep(4000);
		
		Alert promptAlert = driver.switchTo().alert();
		Assert.assertTrue(promptAlert.getText().contains("Your Name Please"));	
		System.out.println(promptAlert.getText());
		
		promptAlert.sendKeys("Abhishek");
		
		promptAlert.accept();
		
		

	}

}
