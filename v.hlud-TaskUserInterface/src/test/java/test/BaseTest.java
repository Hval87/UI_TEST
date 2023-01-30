package test;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected Browser browser=AqualityServices.getBrowser();
    @BeforeTest
    public void setUp(){
        browser.maximize();
        System.out.println(browser);
    }
    @AfterSuite
    public void tearDown(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        browser.quit();
    }
}
