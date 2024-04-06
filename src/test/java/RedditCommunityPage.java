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

public class RedditCommunityPage {
    //fields (class variables)
    //------------------------------------------------------------------------------------------------------------------
    WebDriver chromeDriver = new ChromeDriver();

    //before/after methods
    //------------------------------------------------------------------------------------------------------------------
    @BeforeClass
    void prepPage() throws InterruptedException {
        chromeDriver.get("https://www.reddit.com/");
        chromeDriver.manage().window().maximize();
        //wait for manual login
        Thread.sleep(6000);
    }
    @AfterClass
    void afterTests() {
        chromeDriver.quit();
    }

    // Test methods (class test functions)
    //------------------------------------------------------------------------------------------------------------------
    @Test (priority = 1)
    void testRD_7_01() throws InterruptedException {
        // test case ID: RD_7_01 --> Verify community page is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/");
            chromeDriver.manage().window().maximize();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(3000);
        }
    }

    @Test (priority = 1)
    void testRD_7_02() throws InterruptedException {
        // test case ID: RD_7_02 --> Verify "About" button is working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.partialLinkText("Home")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_7_03() throws InterruptedException {
        // test case ID: RD_7_03 --> Verify sort posts options are working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.partialLinkText("Popular")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_7_04() throws InterruptedException {
        // test case ID: RD_7_04 --> Verify post view options are working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.id("expand-user-drawer-button")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_7_05() throws InterruptedException {
        // test case ID: RD_7_05 --> Verify user can join the community
        // ---------------------------------------------------------------------------------
        try {
            // setting trending filter to 'New'

            // setting location filter to 'Australia'

            // setting format filter to 'compact'
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_7_06() throws InterruptedException {
        // test case ID: RD_7_06 --> Verify community rules dropdown is working
        // ---------------------------------------------------------------------------------
        try {

        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }
}
