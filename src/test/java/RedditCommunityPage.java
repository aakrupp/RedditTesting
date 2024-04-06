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
    void testRD_7_01() throws InterruptedException {
        // test case ID: RD_7_01 --> Verify community page is working
        // ---------------------------------------------------------------------------------
        try {
            // opening reddit
            chromeDriver.get("https://www.reddit.com/r/aww/");
            chromeDriver.manage().window().maximize();
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
    void testRD_7_02() throws InterruptedException {
        // test case ID: RD_7_02 --> Verify user can view community options
        // ---------------------------------------------------------------------------------
        try {
            chromeDriver.findElement(By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/report-flow-provider/div/div[1]/div[1]/section/div/div[2]/shreddit-subreddit-header-buttons"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div > shreddit-subreddit-overflow-control"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("faceplate-dropdown-menu > button")).click();
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
            //click sort dropdown
            chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/div/shreddit-sort-dropdown"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("faceplate-dropdown-menu > faceplate-tooltip > faceplate-tracker > button")).click();
            //change sort to new
            chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/div/shreddit-sort-dropdown/div[3]/li[2]/a")).click();
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
    void testRD_7_04() throws InterruptedException {
        // test case ID: RD_7_04 --> Verify post view options are working
        // ---------------------------------------------------------------------------------
        //click dropdown
        chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/shreddit-layout-event-setter/shreddit-sort-dropdown"))
                .getShadowRoot()
                .findElement(By.cssSelector("faceplate-dropdown-menu > faceplate-tooltip > faceplate-tracker > button")).click();
        //click Compact option
        chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/shreddit-layout-event-setter/shreddit-sort-dropdown/div[3]/data[2]/li/a")).click();
        Thread.sleep(2000);
        //click dropdown again
        chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/shreddit-layout-event-setter/shreddit-sort-dropdown"))
                .getShadowRoot()
                .findElement(By.cssSelector("faceplate-dropdown-menu > faceplate-tooltip > faceplate-tracker > button")).click();
        //click card option
        chromeDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/shreddit-async-loader/div/shreddit-layout-event-setter/shreddit-sort-dropdown/div[3]/data[1]/li/a")).click();
        Thread.sleep(2000);
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
            //join community
            chromeDriver.findElement(By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/report-flow-provider/div/div[1]/div[1]/section/div/div[2]/shreddit-subreddit-header-buttons"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div > faceplate-tracker > shreddit-join-button"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("button")).click();
            Thread.sleep(2000);
            //leave community
            chromeDriver.findElement(By.xpath("/html/body/shreddit-app/dsa-transparency-modal-provider/report-flow-provider/div/div[1]/div[1]/section/div/div[2]/shreddit-subreddit-header-buttons"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("div > faceplate-tracker > shreddit-join-button"))
                    .getShadowRoot()
                    .findElement(By.cssSelector("button")).click();
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
            //rule 1
            chromeDriver.findElement(By.xpath("//*[@id=\"subreddit-right-rail__partial\"]/aside/div/div[2]/div[2]/faceplate-expandable-section-helper[1]/details/summary/faceplate-tracker/li/div")).click();
            //rule 2
            chromeDriver.findElement(By.xpath("//*[@id=\"subreddit-right-rail__partial\"]/aside/div/div[2]/div[2]/faceplate-expandable-section-helper[2]/details/summary/faceplate-tracker/li/div")).click();
            //rule 3
            chromeDriver.findElement(By.xpath("//*[@id=\"subreddit-right-rail__partial\"]/aside/div/div[2]/div[2]/faceplate-expandable-section-helper[3]/details/summary/faceplate-tracker/li/div")).click();
            //rule 4
            chromeDriver.findElement(By.xpath("//*[@id=\"subreddit-right-rail__partial\"]/aside/div/div[2]/div[2]/faceplate-expandable-section-helper[4]/details/summary/faceplate-tracker/li/div")).click();
            //rule 5
            chromeDriver.findElement(By.xpath("//*[@id=\"subreddit-right-rail__partial\"]/aside/div/div[2]/div[2]/faceplate-expandable-section-helper[5]/details/summary/faceplate-tracker/li/div")).click();
            //rule 6
            chromeDriver.findElement(By.xpath("//*[@id=\"subreddit-right-rail__partial\"]/aside/div/div[2]/div[2]/faceplate-expandable-section-helper[6]/details/summary/faceplate-tracker/li/div")).click();
            //rule 7
            chromeDriver.findElement(By.xpath("//*[@id=\"subreddit-right-rail__partial\"]/aside/div/div[2]/div[2]/faceplate-expandable-section-helper[7]/details/summary/faceplate-tracker/li/div")).click();
            //rule 8
            chromeDriver.findElement(By.xpath("//*[@id=\"subreddit-right-rail__partial\"]/aside/div/div[2]/div[2]/faceplate-expandable-section-helper[8]/details/summary/faceplate-tracker/li/div")).click();
            //rule 9
            chromeDriver.findElement(By.xpath("//*[@id=\"subreddit-right-rail__partial\"]/aside/div/div[2]/div[2]/faceplate-expandable-section-helper[9]/details/summary/faceplate-tracker/li/div")).click();
            //rule 10
            chromeDriver.findElement(By.xpath("//*[@id=\"subreddit-right-rail__partial\"]/aside/div/div[2]/div[2]/faceplate-expandable-section-helper[10]/details/summary/faceplate-tracker/li/div")).click();
            //rule 11
            chromeDriver.findElement(By.xpath("//*[@id=\"subreddit-right-rail__partial\"]/aside/div/div[2]/div[2]/faceplate-expandable-section-helper[11]/details/summary/faceplate-tracker/li/div")).click();
        } catch (Exception e){
            //just here to assert test not passed
            Assert.assertEquals(0,1);
        } finally {
            Assert.assertEquals(1,1);
            Thread.sleep(2000);
        }
    }
}
