package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import configExample.ReadConfigFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginExample {

    // precondition
    //ctrl+shift+O - auto-import
    
    WebDriver driver;
    Logger log;
    ReadConfigFile conf ;

    @BeforeTest
    public void launchApp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        
        conf = new ReadConfigFile();
        
        
        
        log = Logger.getLogger("Steria_Org_Automation_Logger_PaymentModule");
        PropertyConfigurator.configure("./configFolder/Log4J_Steria.properties");
        
        
        log.info("chrome browser launched");
        
        
        
        
        driver.get(conf.getAppURL());
        
        
        log.info("HRM Login application opened - " + conf.getAppURL());
    }

    @AfterTest
    public void closeApp() throws Exception {

        log.info("Chrome browser closed");
        Thread.sleep(5000);
        driver.close();
        
    }

    //by default priority - 0
    //priority same - by default execution as per naming con - aplha
    //highest negative number - highest priority
    
    
    @Test(priority = 1)
    public void verifyLoginFeature() throws Exception {

        log.info("-------Test execution started----------");
        
        //ctrl+/ - comment and uncomments
        
        log.info("enter userName: " + conf.getAdminUserName());
        driver.findElement(By.id("txtUsername")).sendKeys(conf.getAdminUserName());
        log.info("enter password: " + conf.getPassword());
        driver.findElement(By.name("txtPassword")).sendKeys(conf.getPassword());
        log.info("click on login button");
        WebElement btnLogin = driver.findElement(By.className("button"));
        btnLogin.click();
        
        System.out.println("adding delay inte.........");
        Thread.sleep(10000);
        //validation step
        //verify text and verify element present
        log.info("verify Dashboard after login");
        WebElement lblDashBoard = driver.findElement(By.tagName("h1"));
        
        System.out.println("verify element present on page: " + lblDashBoard.isDisplayed());
        System.out.println("Label value are : " + lblDashBoard.getText());
        
        log.info("verify label Text" + lblDashBoard.getText());
        Assert.assertEquals(lblDashBoard.getText(), "Dashboard");
        Assert.assertTrue(lblDashBoard.isDisplayed(), "verification of dashboard element get failed");
        
        
    }
    
    @Test(priority = 2)
    public void verifyLogout() throws Exception {

        System.out.println("logout test case");
        
        WebElement btnWelcome = driver.findElement(By.partialLinkText("Welcome"));
        btnWelcome.click();
        
        Thread.sleep(4000);
        log.info("logout from application");
        WebElement btnLogout = driver.findElement(By.linkText("Logout"));
        btnLogout.click();

    }
    
    
    //@Test
    public void verifyForgotPassword() throws Exception {

        System.out.println("verifyForgotPassword test case");
        
        WebElement lnkForgotPassword = driver.findElement(By.partialLinkText("Forgot your pas"));
        lnkForgotPassword.click();
        
        
        Thread.sleep(4000);
        
        //validation
        //https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode
        String actualAppURL = driver.getCurrentUrl();
        Assert.assertTrue(actualAppURL.contains("requestPasswordResetCode"));
        
        
        //click on Cancel button
        Thread.sleep(2000);
        
        WebElement btnCancel = driver.findElement(By.xpath("//input[@value='Cancel']"));
        btnCancel.click();
        
        //------------------------------------------
        
        Thread.sleep(2000);
        
        WebElement lnk_ForgotPassword = driver.findElement(By.partialLinkText("your pas"));
        lnk_ForgotPassword.click();
        
        
        Thread.sleep(4000);
        
        //validation
        //https://opensource-demo.orangehrmlive.com/index.php/auth/requestPasswordResetCode
        String actual_AppURL = driver.getCurrentUrl();
        Assert.assertTrue(actual_AppURL.contains("requestPasswordResetCode"));
        
        //click on Cancel button
        Thread.sleep(2000);
                
        WebElement btn_Cancel = driver.findElement(By.cssSelector("input[value='Cancel']"));
        btn_Cancel.click();
        
        Thread.sleep(4000);

    }

}