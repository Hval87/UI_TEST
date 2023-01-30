package test;

import Page.MainPage;
import Page.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class Test4 extends BaseTest {
    @Test
    public void test4(){
        browser.goTo("https://userinyerface.com/");
        MainPage mainPage=new MainPage();
        mainPage.redirectToNextPage();
        SignInPage signInPage=new SignInPage();
        Assert.assertTrue(signInPage.state().isDisplayed());
        Assert.assertEquals(signInPage.getClockText(),"00:00:00","clock time is not equal 00:00:00");

    }
}
