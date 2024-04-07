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
                .findElement(By.cssSelector("#login > faceplate-tabpanel > auth-flow-modal:nth-child(1) > div.w-100 > faceplate-tracker > button")).click();
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
            // opening reddit
            chromeDriver.get("https://www.reddit.com/submit?type=TEXT");
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
    void testRD_4_02() throws InterruptedException {
        // test case ID: RD_4_02 --> Verify that "select a community" dropdown is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/submit?type=TEXT");
            chromeDriver.manage().window().maximize();
            Thread.sleep(3000);

            // click "Select a Community"
            chromeDriver.findElement(By.className("_3cWzf-usAKfGV1Ay7h2zM_")).click();

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
        // test case ID: RD_4_03 --> Verify that "Images & Video" button is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/submit?type=TEXT");
            chromeDriver.manage().window().maximize();
            Thread.sleep(3000);

            // click body text box and enter text
            chromeDriver.findElement(By.className("Z1w8VkpQ23E1Wdq_My3U4 ")).click();

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
            // opening reddit
            chromeDriver.get("https://www.reddit.com/submit?type=TEXT");
            chromeDriver.manage().window().maximize();
            Thread.sleep(3000);

            chromeDriver.findElement(By.className("_5x1WjCc4HQF6tqnODOql0 _2iuoyPiKHN3kfOoeIQalDT _2tU8R9NTqhvBrhoNAXWWcP HNozj_dKjQZ59ZsfEegz8 ")).click();

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
            // opening reddit
            chromeDriver.get("https://www.reddit.com/submit?type=TEXT");
            chromeDriver.manage().window().maximize();
            Thread.sleep(3000);

            // click the drafts button
            chromeDriver.findElement(By.className("_3KQDVc4kBIwA5u7S9n99NQ _2iuoyPiKHN3kfOoeIQalDT _3zbhtNO0bdck0oYbYRhjMC HNozj_dKjQZ59ZsfEegz8 ")).click();

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
            // opening reddit
            chromeDriver.get("https://www.reddit.com/submit?type=TEXT");
            chromeDriver.manage().window().maximize();
            Thread.sleep(3000);

            // click the markdown button
            chromeDriver.findElement(By.className("-CJZhr1W053faqFXFYgXO")).click();

        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

}
