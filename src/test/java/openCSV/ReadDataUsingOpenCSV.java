package openCSV;

import java.io.FileReader;
import java.io.IOException;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import io.github.bonigarcia.wdm.WebDriverManager;

//import au.com.bytecode.opencsv.CSVReader;

 
//import io.github.bonigarcia.wdm.WebDriverManager;
public class ReadDataUsingOpenCSV {
 
   // String CSV_PATH = "./testData/TestData.csv";
    String CSV_PATH = "C:\\Users\\Act\\OneDrive\\Desktop\\Appium\\TestData.csv";
    WebDriver driver;
    private CSVReader csvReader;
    String[] csvCell;
 
    @BeforeTest
    public void setup() throws Exception {
 
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.com");
    }
 
    @Test
    public void dataRead_CSV() throws IOException, Exception {
        //Create an object of CSVReader
        csvReader = new CSVReader(new FileReader(CSV_PATH));
 
        driver.findElement(By.id("nav-link-accountList")).click();
        driver.findElement(By.id("createAccountSubmit")).click();
 
        //You can use while loop like below, It will be executed until the last line in CSV used. 
        while ((csvCell = csvReader.readNext()) != null) {
            String CustomerName = csvCell[0];
            String CustomerEmail = csvCell[1];
            String CustomerPassword = csvCell[2];
            String CustomerConfirmPassword = csvCell[3];
            //String CustomerConfirmPassword = csvCell[4];
            
            driver.findElement(By.id("ap_customer_name")).clear();
            driver.findElement(By.id("ap_customer_name")).sendKeys(CustomerName);
            
            Thread.sleep(2000);
            
            driver.findElement(By.id("ap_email")).clear();
            driver.findElement(By.id("ap_email")).sendKeys(CustomerEmail);
            Thread.sleep(2000);
            driver.findElement(By.id("ap_password")).clear();
            driver.findElement(By.id("ap_password")).sendKeys(CustomerPassword);
            Thread.sleep(2000);
            driver.findElement(By.id("ap_password_check")).clear();
            driver.findElement(By.id("ap_password_check")).sendKeys(CustomerConfirmPassword);
            driver.findElement(By.id("continue")).click();
            Thread.sleep(4000);
        }
    }
 
    @AfterTest
    public void exit() {
        driver.close();
        driver.quit();
    }
}