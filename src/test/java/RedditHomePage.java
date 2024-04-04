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

public class RedditHomePage {
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
    void testRD_2_01() throws InterruptedException {
        // test case ID: RD_2_01 --> Verify home page is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/");
            chromeDriver.manage().window().maximize();
        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(3000);
        }
    }

    @Test (priority = 1)
    void testRD_2_02() throws InterruptedException {
        // test case ID: RD_2_02 --> Verify that home button is working
        // ---------------------------------------------------------------------------------
        // pressing home button in the already open browser
        try {
            chromeDriver.findElement(By.partialLinkText("Home")).click();
        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_2_03() throws InterruptedException {
        // test case ID: RD_2_03 --> Verify popular button is working
        // ---------------------------------------------------------------------------------
        // pressing popular button in the already open browser
        try {
            chromeDriver.findElement(By.partialLinkText("Popular")).click();
        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_2_04() throws InterruptedException {
        // test case ID: RD_2_04 --> Verify settings menu works
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.id("expand-user-drawer-button")).click();
        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_2_05() throws InterruptedException {
        // test case ID: RD_2_05 --> Verify the different post filters are working
        // ---------------------------------------------------------------------------------
        try {
            // setting trending filter to 'New'

            // setting location filter to 'Australia'

            // setting format filter to 'compact'
        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_2_06() throws InterruptedException {
        // test case ID: RD_2_06 --> Verify search bar works
        // ---------------------------------------------------------------------------------
        try {

        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_2_07() throws InterruptedException {
        // test case ID: RD_2_07 --> Verify navigation bar dropdowns are working
        // ---------------------------------------------------------------------------------
        try {

        } catch (Exception e){
            //just here to assert test passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }
}
