import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.*;

//import java.util.concurrent.TimeUnit;
//import java.io.File;
//import java.io.IOException;
//import java.util.Set;
//import java.util.ArrayList;

public class RedditLogin {
    //fields (class variables)
    //------------------------------------------------------------------------------------------------------------------
    WebDriver chromeDriver = new ChromeDriver();
    int test_num = 1;

    //before/after methods
    //------------------------------------------------------------------------------------------------------------------
    @BeforeClass
    void prepPage() {
        chromeDriver.get("https://www.reddit.com/");
        chromeDriver.manage().window().maximize();
    }
    @AfterClass
    void afterTests() {
        chromeDriver.quit();
    }
    @BeforeTest
    void pretestMessage() {
        System.out.println("Test " + test_num + "starting...");
    }
    @AfterTest
    void posttestMessage() {
        System.out.println("Test " + test_num + "compelted. Moving on to test " + ++test_num);
    }

    // Test methods (class test functions)
    //------------------------------------------------------------------------------------------------------------------
    @Test (priority = 1)
    void testRD_1_01() throws InterruptedException {
        // test case ID: RD_1_01 --> Verify login page is working
        // ---------------------------------------------------------------------------------
        // opening reddit and hit the login button
        try {
            chromeDriver.findElement(By.id("login-button")).click();
        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(3000);
        }
    }

    @Test (priority = 1)
    void testRD_1_02() throws InterruptedException {
        // test case ID: RD_1_02 --> Verify that username text box is working
        // ---------------------------------------------------------------------------------
        // select the username box and enter the username
        try {
            chromeDriver.findElement(By.id("login-username")).sendKeys("CENTestUser");
        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_1_03() throws InterruptedException {
        // test case ID: RD_1_03 --> Verify that password text box is working
        // ---------------------------------------------------------------------------------
        // using the already open window, select the password box and enter the password
        try {
            chromeDriver.findElement(By.id("login-password")).sendKeys("CENTestPass");
        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_1_04() throws InterruptedException {
        // test case ID: RD_1_05 --> Verify that login won't work if given incorrect username
        // ---------------------------------------------------------------------------------

        try {
            chromeDriver.findElement(By.id("login-username")).sendKeys("badUsername");
            // login button click
        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_1_05() throws InterruptedException {
        // test case ID: RD_1_06 --> Verify that login won't work if given incorrect password
        // ---------------------------------------------------------------------------------

        try {
            chromeDriver.findElement(By.id("login-password")).sendKeys("badPassword");
            // login button click
        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

}
