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

public class RedditTopicsPage {
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
    void testRD_3_01() throws InterruptedException {
        // test case ID: RD_3_01 --> Verify topic page is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit NFL topic page
            chromeDriver.get("https://www.reddit.com/t/nfl/");
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
    void testRD_3_02() throws InterruptedException {
        // test case ID: RD_3_02 --> Verify that links below the topic are working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit NFL topic page
            chromeDriver.get("https://www.reddit.com/t/nfl/");
            chromeDriver.manage().window().maximize();

            // click the "Professional football" link
            chromeDriver.findElement(By.linkText("Professional football")).click();

        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(3000);
        }
    }

    @Test (priority = 1)
    void testRD_3_03() throws InterruptedException {
        // test case ID: RD_3_03 --> Verify that links below the topic in the subtopic are working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit NFL topic page
            chromeDriver.get("https://www.reddit.com/t/professional_football/");
            chromeDriver.manage().window().maximize();

            // click the "Professional sports" link
            chromeDriver.findElement(By.linkText("Football")).click();


        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(3000);
        }
    }

    @Test (priority = 1)
    void testRD_3_04() throws InterruptedException {
        // test case ID: RD_3_04 --> Verify that "Communities" button is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit NFL topic page
            chromeDriver.get("https://www.reddit.com/t/nfl/");
            chromeDriver.manage().window().maximize();

            // click the "Communities" button
            chromeDriver.findElement(By.xpath("//*[@noun='communities']")).click();

        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(3000);
        }
    }

    @Test (priority = 1)
    void testRD_3_05() throws InterruptedException {
        // test case ID: RD_3_05 --> Verify that "Related Topics" button is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit NFL topic page
            chromeDriver.get("https://www.reddit.com/t/nfl/");
            chromeDriver.manage().window().maximize();

            // click the "Related Topics" button
            chromeDriver.findElement(By.xpath("//*[@noun='related_topics']")).click();

        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(3000);
        }
    }

}
