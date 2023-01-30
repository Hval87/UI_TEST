package test;

import Page.HelpWindowPage;
import Page.MainPage;
import Page.SignInPage;
import aquality.selenium.browser.AqualityServices;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;

public class Test2 extends BaseTest {
    @Test
    public void test2(){
        browser.goTo("https://userinyerface.com/");
        MainPage mainPage=new MainPage();
        mainPage.redirectToNextPage();
        SignInPage signInPage=new SignInPage();
        Assert.assertTrue(signInPage.state().isDisplayed(),"sign in page is not opened yet");
        HelpWindowPage helpWindowPage=new HelpWindowPage();
        helpWindowPage.clickToHideForm();
        boolean flag=AqualityServices.getConditionalWait().waitFor(()->helpWindowPage.state().waitForNotDisplayed());
        Assert.assertTrue(helpWindowPage.state().waitForNotDisplayed(),"help window is still opened");





    }

}
