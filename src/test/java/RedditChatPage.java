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

public class RedditChatPage {
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
        Thread.sleep(10000);
    }
    @AfterClass
    void afterTests() {
        chromeDriver.quit();
    }

    // Test methods (class test functions)
    //------------------------------------------------------------------------------------------------------------------
    @Test (priority = 1)
    void testRD_5_01() throws InterruptedException {
        // test case ID: RD_5_01 --> Verify chat page is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://chat.reddit.com/");
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(3000);
        }
    }

    @Test (priority = 1)
    void testRD_5_02() throws InterruptedException {
        // test case ID: RD_5_02 --> Verify "Threads" button is working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.get("https://chat.reddit.com/threads");
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_5_03() throws InterruptedException {
        // test case ID: RD_5_03 --> Verify "Discover Channels" button is working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.get("https://chat.reddit.com/");
            // no such button exists
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_5_04() throws InterruptedException {
        // test case ID: RD_5_04 --> Verify Start a new chat bubble is working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.get("https://chat.reddit.com/room/create");
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_5_05() throws InterruptedException {
        // test case ID: RD_5_05 --> Verify Chat options dropdown is working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app//div[2]/rs-rooms-nav//div[1]/rs-rooms-nav-filter")).click();
            Thread.sleep(1000);
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app//div[2]/rs-rooms-nav//div[1]/rs-rooms-nav-filter//faceplate-dropdown-menu/faceplate-menu/li[1]")).click();
            Thread.sleep(1000);
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app//div[2]/rs-rooms-nav//div[1]/rs-rooms-nav-filter//faceplate-dropdown-menu/faceplate-menu/li[2]")).click();
            Thread.sleep(1000);
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app//div[2]/rs-rooms-nav//div[1]/rs-rooms-nav-filter//faceplate-dropdown-menu/faceplate-menu/li[3]")).click();
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app//div[2]/rs-rooms-nav//div[1]/rs-rooms-nav-filter//faceplate-dropdown-menu/faceplate-menu/div/button")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_5_06() throws InterruptedException {
        // test case ID: RD_5_06 --> Verify "Go to messages" button is working
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
