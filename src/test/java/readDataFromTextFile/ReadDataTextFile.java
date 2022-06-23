package readDataFromTextFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDataTextFile {

	public static void main(String[] args) throws IOException, Exception {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		
		//FileReader fis = new FileReader("./testData/testData.txt");
		// Method1

		/*
		 * BufferedReader br = new BufferedReader(fis); String SearchText;
		 * 
		 * while((SearchText= br.readLine())!= null) { System.out.println(SearchText);
		 * 
		 * driver.findElement(By.id("twotabsearchtextbox")).sendKeys(SearchText);
		 * Thread.sleep(2000); driver.findElement(By.id("twotabsearchtextbox")).clear();
		 * Thread.sleep(2000); }
		 */
		
		
		//Method2
		
		File file = new File("./testData/testData.txt");
		Scanner sc = new Scanner(file);
		
		while(sc.hasNextLine())
		{
			
			//System.out.println(sc.nextLine());
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys(sc.nextLine());
			Thread.sleep(2000);
			driver.findElement(By.id("twotabsearchtextbox")).clear();
			Thread.sleep(2000);
			
		}
		
		
	}

}
