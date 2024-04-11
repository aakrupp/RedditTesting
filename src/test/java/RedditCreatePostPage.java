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

public class RedditCreatePostPage {
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
                .findElement(By.cssSelector("#login > auth-flow-modal > div.w-100 > faceplate-tracker > button")).click();
        // ++++++++++++++
        Thread.sleep(2000);
    }
    @AfterClass
    void afterTests() {
        chromeDriver.close();
    }

    // Test methods (class test functions)
    //------------------------------------------------------------------------------------------------------------------
    @Test (priority = 1)
    void testRD_4_01() throws InterruptedException {
        // test case ID: RD_4_01 --> Verify create post page is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit create post page
            chromeDriver.get("https://www.reddit.com/submit?type=TEXT");
            chromeDriver.manage().window().maximize();
            Thread.sleep(3000);

        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(3000);
        }
    }

    @Test (priority = 1)
    void testRD_4_02() throws InterruptedException {
        // test case ID: RD_4_02 --> Verify that "select a community" dropdown is working
        // ---------------------------------------------------------------------------------
        try {
            // click "Select a Community" dropdown
            chromeDriver.findElement(By.className("_3cWzf-usAKfGV1Ay7h2zM_")).click();
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
    void testRD_4_03() throws InterruptedException {
        // test case ID: RD_4_03 --> Verify that text box is working
        // ---------------------------------------------------------------------------------
        try {
            // entering text into textbox
            chromeDriver.findElement(By.xpath("//*[@role='textbox']")).sendKeys("Testing text");
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
    void testRD_4_04() throws InterruptedException {
        // test case ID: RD_4_04 --> Verify that "Add Tags" button is working
        // ---------------------------------------------------------------------------------
        try {
            // clicking the 'NSFW' button to add the tag to the post
            chromeDriver.findElement(By.xpath("//*[@aria-label='Mark as Not Safe For Work']")).click();
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
    void testRD_4_05() throws InterruptedException {
        // test case ID: RD_4_05 --> Verify that "Drafts" button is working
        // ---------------------------------------------------------------------------------
        try {
            // click the drafts button
            chromeDriver.findElement(By.className("_2qdAvPbBMsK4TpwNnVe-pj")).click();
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
    void testRD_4_06() throws InterruptedException {
        // test case ID: RD_4_06 --> Verify that "Markdown Editor" button is working
        // ---------------------------------------------------------------------------------
        try {
            // click the markdown button to open it
            chromeDriver.findElement(By.xpath("//*[@aria-label='Switch to markdown']")).click();
            Thread.sleep(2000);

        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

}
