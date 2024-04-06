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

public class RedditProfilePage {
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
    void testRD_6_01() throws InterruptedException {
        // test case ID: RD_6_01 --> Verify profile page is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/user/CENTestingUser/");
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
    void testRD_6_02() throws InterruptedException {
        // test case ID: RD_6_02 --> Verify "Posts" button is working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.xpath("//*[@id=\"profile-feed-tabgroup\"]/a[2]")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_6_03() throws InterruptedException {
        // test case ID: RD_6_03 --> Verify "Comments" button is working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.xpath("//*[@id=\"profile-feed-tabgroup\"]/a[3]")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_6_04() throws InterruptedException {
        // test case ID: RD_6_04 --> Verify "Saved" button is working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.xpath("//*[@id=\"profile-feed-tabgroup\"]/a[4]")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_6_05() throws InterruptedException {
        // test case ID: RD_6_05 --> Verify "Hidden" button is working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.xpath("//*[@id=\"profile-feed-tabgroup\"]/a[5]")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_6_06() throws InterruptedException {
        // test case ID: RD_6_06 --> Verify "Upvoted" button is working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.xpath("//*[@id=\"profile-feed-tabgroup\"]/a[6]")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }
    @Test (priority = 1)
    void testRD_6_07() throws InterruptedException {
        // test case ID: RD_6_07 --> Verify "Downvoted" button is working
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.xpath("//*[@id=\"profile-feed-tabgroup\"]/a[7]")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }
}
