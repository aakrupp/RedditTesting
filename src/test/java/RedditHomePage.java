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
        // chromeDriver.quit();
    }

    // Test methods (class test functions)
    //------------------------------------------------------------------------------------------------------------------
    @Test(priority = 1)
    void testRD_2_01() throws InterruptedException {
        // test case ID: RD_2_01 --> Verify home page is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/");
            chromeDriver.manage().window().maximize();

        } catch (Exception e) {
            //just here to assert test not passed
            Assert.assertEquals(0, 1);
        } finally {
            Assert.assertEquals(1, 1);
            Thread.sleep(3000);
        }
    }

    @Test(priority = 1)
    void testRD_2_02() throws InterruptedException {
        // test case ID: RD_2_02 --> Verify profile menu works
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/");
            chromeDriver.manage().window().maximize();

            // click on profile menu button
            chromeDriver.findElement(By.id("expand-user-drawer-button")).click();

        } catch (Exception e) {
            //just here to assert test not passed
            Assert.assertEquals(0, 1);
        } finally {
            Assert.assertEquals(1, 1);
            Thread.sleep(2000);
        }
    }

    @Test(priority = 1)
    void testRD_2_03() throws InterruptedException {
        // test case ID: RD_2_03 --> Verify chat button works
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/");
            chromeDriver.manage().window().maximize();

            // click chat button
            chromeDriver.findElement(By.id("header-action-item-chat-button")).click();

        } catch (Exception e) {
            //just here to assert test not passed
            Assert.assertEquals(0, 1);
        } finally {
            Assert.assertEquals(1, 1);
            Thread.sleep(2000);
        }
    }

    @Test(priority = 1)
    void testRD_2_04() throws InterruptedException {
        // test case ID: RD_2_04 --> Verify navigation bar dropdowns are working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/");
            chromeDriver.manage().window().maximize();
            Thread.sleep(10000);

            // click 'Resources' dropdown
            chromeDriver.findElement(By.xpath("//*[@noun='resources_menu']")).click();
            // content_policy_menu

        } catch (Exception e) {
            //just here to assert test not passed
            Assert.assertEquals(0, 1);
        } finally {
            Assert.assertEquals(1, 1);
            Thread.sleep(2000);
        }
    }

    @Test(priority = 1)
    void testRD_2_05() throws InterruptedException {
        // test case ID: RD_2_05 --> Verify bottom links are working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/");
            chromeDriver.manage().window().maximize();
            Thread.sleep(2000);

            // click 'Resources' dropdown
            chromeDriver.findElement(By.xpath("//*[@noun='content_policy_menu']")).click();

        } catch (Exception e) {
            //just here to assert test not passed
            Assert.assertEquals(0, 1);
        } finally {
            Assert.assertEquals(1, 1);
            Thread.sleep(2000);
        }
    }
}