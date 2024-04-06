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

    // Test methods (class test functions)
    //------------------------------------------------------------------------------------------------------------------
    @Test (priority = 1)
    void testRD_1_01() throws InterruptedException {
        // test case ID: RD_1_01 --> Verify login page is working
        // ---------------------------------------------------------------------------------
        try {
            // clicking login button
            chromeDriver.findElement(By.id("login-button")).click();
        } catch (Exception e){
            //just here to assert test not passed
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
        try {
            //navigate to login exclusive page for the rest of tests
            chromeDriver.get("https://www.reddit.com/login/");
            Thread.sleep(2000);
            // entering username
            chromeDriver.findElement(By.id("login-username")).sendKeys("CENTestUser");
        } catch (Exception e){
            //just here to assert test not passed
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
        try {
            // entering valid password
            chromeDriver.findElement(By.id("login-password")).sendKeys("CENTestPass");
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_1_04() throws InterruptedException {
        // test case ID: RD_1_04 --> Verify user can be logged in
        // ---------------------------------------------------------------------------------
        try {
            //reload page
            chromeDriver.get("https://www.reddit.com/login/");
            Thread.sleep(2000);

            // enter valid username and password
            chromeDriver.findElement(By.id("login-username")).sendKeys("CENTestingUser");
            chromeDriver.findElement(By.id("login-password")).sendKeys("CENTestingPass");
            Thread.sleep(1000);

            // login button click
            // ++++++++++++++ help pls!!!!
            chromeDriver.findElement(By.xpath("/html/body/shreddit-app/shreddit-overlay-display"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("shreddit-signup-drawer"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("shreddit-drawer > div > shreddit-async-loader > div > shreddit-slotter"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("#login > faceplate-tabpanel > auth-flow-modal:nth-child(1) > div.w-100 > faceplate-tracker > button")).click();
            // ++++++++++++++

        } catch (Exception e){
            //just here to assert test not passed
            System.out.println(e);
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_1_05() throws InterruptedException {
        // test case ID: RD_1_05 --> Verify that login won't work if given incorrect username
        // ---------------------------------------------------------------------------------

        try {
            // clicking login button
            chromeDriver.findElement(By.id("login-button")).click();

            // enter invalid username and valid password
            chromeDriver.findElement(By.id("login-username")).sendKeys("badUsername");
            chromeDriver.findElement(By.id("login-password")).sendKeys("CENTestPass");

            // login button click

        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_1_06() throws InterruptedException {
        // test case ID: RD_1_06 --> Verify that login won't work if given incorrect password
        // ---------------------------------------------------------------------------------

        try {
            // clicking login button
            chromeDriver.findElement(By.id("login-button")).click();
            Thread.sleep(2000);

            // enter valid username and invalid password
            chromeDriver.findElement(By.id("login-username")).sendKeys("CENTestUser");
            chromeDriver.findElement(By.id("login-password")).sendKeys("badPassword");
            Thread.sleep(2000);

            // click login button
            chromeDriver.findElement(By.xpath("@src='onboarding'")).click();

        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);

        }
    }

}
