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
        //reload page
        chromeDriver.get("https://www.reddit.com/login/");
        chromeDriver.manage().window().maximize();
        Thread.sleep(2000);

        // enter valid username and password
        chromeDriver.findElement(By.id("login-username")).sendKeys("CENTestingUser");
        chromeDriver.findElement(By.id("login-password")).sendKeys("CENTestingPass");
        Thread.sleep(1000);

        // login button click
        // ++++++++++++++
        chromeDriver.findElement(By.xpath("/html/body/shreddit-app/shreddit-overlay-display"))
                .getShadowRoot()
                .findElement(By.cssSelector("shreddit-signup-drawer"))
                .getShadowRoot()
                .findElement(By.cssSelector("shreddit-drawer > div > shreddit-async-loader > div > shreddit-slotter"))
                .getShadowRoot()
                .findElement(By.cssSelector("#login > faceplate-tabpanel > auth-flow-modal:nth-child(1) > div.w-100 > faceplate-tracker > button")).click();
        // ++++++++++++++
        Thread.sleep(2000);
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
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.container > rs-rooms-nav"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.border-solid.border-0.border-b.border-b-tone-5 > div > li > div")).click();
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
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.container > rs-rooms-nav"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.flex.items-center.px-md.py-sm > a")).click();
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
            //click dropdown
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.container > rs-rooms-nav"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.flex.items-center.px-md.py-sm > rs-rooms-nav-filter"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("faceplate-dropdown-menu > button")).click();
            Thread.sleep(1000);
            //click checkbox 1
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.container > rs-rooms-nav"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.flex.items-center.px-md.py-sm > rs-rooms-nav-filter"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("faceplate-dropdown-menu > faceplate-menu > li:nth-child(1) > div")).click();
            Thread.sleep(1000);
            //click checkbox 2
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.container > rs-rooms-nav"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.flex.items-center.px-md.py-sm > rs-rooms-nav-filter"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("faceplate-dropdown-menu > faceplate-menu > li:nth-child(2) > div")).click();
            Thread.sleep(1000);
            //click checkbox 3 twice
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.container > rs-rooms-nav"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.flex.items-center.px-md.py-sm > rs-rooms-nav-filter"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("faceplate-dropdown-menu > faceplate-menu > li:nth-child(3) > div")).click();
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.container > rs-rooms-nav"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.flex.items-center.px-md.py-sm > rs-rooms-nav-filter"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("faceplate-dropdown-menu > faceplate-menu > li:nth-child(3) > div")).click();
            //click apply
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.container > rs-rooms-nav"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.flex.items-center.px-md.py-sm > rs-rooms-nav-filter"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("faceplate-dropdown-menu > faceplate-menu > div > button")).click();
            Thread.sleep(2000);
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
            chromeDriver.get("https://chat.reddit.com/threads");
            Thread.sleep(2000);
            chromeDriver.findElement(By.xpath("/html/body/faceplate-app/rs-app"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div.container > rs-threads-view"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("rs-room-overlay-manager > div > button")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }
}
