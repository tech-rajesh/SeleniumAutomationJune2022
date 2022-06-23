package controlDemoExample;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HandleCheckboxRadioButton extends BaseTest {

	@Test(priority = 1)
	public void checkboxTest() {

		driver.findElements(By.xpath("//input[@type='checkbox']")).get(1).click(); // Car checkbox

	}

	@Test(priority = 2)
	public void radioButtonTest() {

		// Radiobutton
		driver.findElement(By.xpath("//input[@value='female']")).click();

	}

}
