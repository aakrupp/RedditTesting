import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.ArrayList;


public class Main {
    private WebDriver chromeDriver;

    // login page testing
    @Test
    void test1() throws InterruptedException {

        WebDriver chromeDriver = new ChromeDriver();


        // test case ID: RD_1_01 --> Verify login page is working
        // ---------------------------------------------------------------------------------
        // opening reddit and hit the login button
        chromeDriver.get("https://www.reddit.com/");
        chromeDriver.manage().window().maximize();
        chromeDriver.findElement(By.id("login-button")).click();

        // waiting 2 seconds to give page time to load
        TimeUnit.SECONDS.sleep(2);

        // test case ID: RD_1_02 --> Verify that username text box is working
        // ---------------------------------------------------------------------------------
        // using the already open window, select the username box and enter the username
        chromeDriver.findElement(By.id("login-username")).sendKeys("username");

        // test case ID: RD_1_03 --> Verify that password text box is working
        // ---------------------------------------------------------------------------------
        // using the already open window, select the password box and enter the password
        chromeDriver.findElement(By.id("login-password")).sendKeys("password");

        // waiting 2 seconds to give page time to load
        TimeUnit.SECONDS.sleep(2);

        // test case ID: RD_1_04 --> Verify user can be logged in
        // ---------------------------------------------------------------------------------
        // using the already open window, select the login button and log in

        // can't get login button working *********************
        // chromeDriver.findElement(By.className("login w-100 button-large px-[var(--rem14)] button-brand items-center " +
        // "justify-center button inline-flex ")).click();


        // test case ID: RD_1_05 --> Verify that login won't work if given incorrect username
        // ---------------------------------------------------------------------------------
        chromeDriver.findElement(By.id("login-username")).sendKeys("badUsername");
        // login button click

        // test case ID: RD_1_06 --> Verify that login won't work if given incorrect password
        // ---------------------------------------------------------------------------------
        chromeDriver.findElement(By.id("login-password")).sendKeys("badPassword");
        // login button click


        // closing the browser
        TimeUnit.SECONDS.sleep(3);
        chromeDriver.close();
    } // end login page testing

    // home page testing
    @Test
    void test2() throws InterruptedException {

        WebDriver chromeDriver = new ChromeDriver();

        // test case ID: RD_2_01 --> Verify home page is working
        // ---------------------------------------------------------------------------------
        // opening reddit
        chromeDriver.get("https://www.reddit.com/");
        chromeDriver.manage().window().maximize();
        // waiting 2 seconds to give page time to load
        TimeUnit.SECONDS.sleep(2);

        // test case ID: RD_2_02 --> Verify that home button is working
        // ---------------------------------------------------------------------------------
        // pressing home button in the already open browser
        // chromeDriver.findElement(By.partialLinkText("Home")).click();

        // test case ID: RD_2_03 --> Verify popular button is working
        // ---------------------------------------------------------------------------------
        // pressing popular button in the already open browser
        // chromeDriver.findElement(By.partialLinkText("Popular")).click();

        // test case ID: RD_2_04 --> Verify settings menu works
        // ---------------------------------------------------------------------------------
        chromeDriver.findElement(By.id("expand-user-drawer-button")).click();

        // test case ID: RD_2_05 --> Verify the different post filters are working
        // ---------------------------------------------------------------------------------
        // setting trending filter to 'New'

        // setting location filter to 'Australia'

        // setting format filter to 'compact'

        // test case ID: RD_2_06 --> Verify search bar works
        // ---------------------------------------------------------------------------------

        // test case ID: RD_2_07 --> Verify navigation bar dropdowns are working
        // ---------------------------------------------------------------------------------


        // closing the browser
        TimeUnit.SECONDS.sleep(3);
        // chromeDriver.close();
    } // end home page testing

} // end Main