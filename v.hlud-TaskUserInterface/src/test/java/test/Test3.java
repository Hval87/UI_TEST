package test;

import Page.MainPage;
import Page.SignInPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class Test3 extends BaseTest {
    @Test
    public void test3(){
        browser.goTo("https://userinyerface.com/");
        MainPage mainPage=new MainPage();
        mainPage.redirectToNextPage();
        SignInPage signInPage=new SignInPage();
        Assert.assertTrue(signInPage.state().isDisplayed());
        signInPage.clickAcceptCookie();
        Assert.assertFalse(signInPage.isWindowCookieDisplayed(),"cookie request is still opened");
    }

}
