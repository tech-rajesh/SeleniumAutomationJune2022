package controlDemoExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HandleListbox extends BaseTest {

	@Test
	public void listboxTest() throws Exception {

		WebElement mutipleList = driver.findElement(By.xpath("//select[@name='FromLB']"));
		
		
		//Select class
		Select list = new Select(mutipleList);
		
		System.out.println("Is listbox allow multiple selection or not : "+list.isMultiple());
		
		list.selectByIndex(0);				//USA
		list.selectByValue("India");		//India
		list.selectByVisibleText("Germany");//Germany
		
		Thread.sleep(4000);
		
		list.deselectByIndex(5);
		list.deselectByValue("USA");
		
	}
	
	
	@Test
	public void listboxTest2() throws Exception {

		WebElement SingleList = driver.findElement(By.xpath("//select"));
		
		Select list = new Select(SingleList);
		
		System.out.println("****Is listbox allow multiple selection or not : "+list.isMultiple());
		
		list.selectByIndex(2);		//Opel
		Thread.sleep(2000);
		list.selectByValue("USA");	//Volovo
		Thread.sleep(2000);
		list.selectByVisibleText("Toyota");
		
	}

	

}
