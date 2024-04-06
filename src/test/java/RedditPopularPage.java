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

public class RedditPopularPage {
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
    void testRD_8_01() throws InterruptedException {
        // test case ID: RD_8_01 --> Verify Popular page is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/r/popular/");
            chromeDriver.navigate().refresh(); //sometimes the page looks different than expected and idk why?
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(3000);
        }
    }

    @Test (priority = 1)
    void testRD_8_02() throws InterruptedException {
        // test case ID: RD_8_02 --> Verify sort by country functionality
        // ---------------------------------------------------------------------------------
        try {
            //click on sort dropdown
            chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div/shreddit-async-loader/div/div/shreddit-sort-dropdown[2]"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("faceplate-dropdown-menu > faceplate-tooltip > faceplate-tracker > button")).click();
            //click on United States
            chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div/shreddit-async-loader/div/div/shreddit-sort-dropdown[2]/div[3]/li[2]/a")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_8_03() throws InterruptedException {
        // test case ID: RD_8_03 --> Verify sort by state functionality
        // ---------------------------------------------------------------------------------
        try {
            //click on sort dropdown
            chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div/shreddit-async-loader/div/div/shreddit-sort-dropdown[3]"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("faceplate-dropdown-menu > faceplate-tooltip > faceplate-tracker > button")).click();
            //click on Florida
            chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div/shreddit-async-loader/div/div/shreddit-sort-dropdown[3]/div[3]/li[11]/a")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_8_04() throws InterruptedException {
        // test case ID: RD_8_04 --> Verify other sort options
        // ---------------------------------------------------------------------------------
        try {
            //click on sort dropdown
            chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div/shreddit-async-loader/div/div/shreddit-sort-dropdown[1]"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("faceplate-dropdown-menu > faceplate-tooltip > faceplate-tracker > button")).click();
            //click on Best
            chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div/shreddit-async-loader/div/div/shreddit-sort-dropdown[1]/div[3]/li[1]/a")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_8_05() throws InterruptedException {
        // test case ID: RD_8_06 --> Verify banner arrow functionality
        // ---------------------------------------------------------------------------------
        try {
            //click the arrow
            chromeDriver.findElement(By.xpath("/html/body/shreddit-app/div/div[1]/div[1]/div/search-dynamic-id-cache-controller/shreddit-gallery-carousel"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div > span.absolute.top-\\[85px\\].hidden.xs\\:inline.right-\\[8px\\].opacity-100.visible > button")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

    @Test (priority = 1)
    void testRD_8_06() throws InterruptedException {
        // test case ID: RD_8_05 --> Verify "Advertise on Reddit" link works
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.xpath("//*[@id=\"RESOURCES\"]/faceplate-tracker[2]/li/a")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }

}
