package test;

import Page.MainPage;
import Page.PersonalDetailsPage;
import Page.SignInPage;
import Page.ThisIsMyPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.BaseTest;
import utils.StringGenerator;

import java.io.IOException;

public class Test1 extends BaseTest {
    @Test
    public void test1(){
        browser.goTo("https://userinyerface.com/");
        MainPage mainPage=new MainPage();
        Assert.assertTrue(mainPage.state().isDisplayed(),"main page is not opened");
        mainPage.redirectToNextPage();
        SignInPage signInPage=new SignInPage();
        Assert.assertTrue(signInPage.state().isDisplayed(),"signinPage is closed");
        String email=String.valueOf(StringGenerator.stringGenerate(5,""));
        signInPage.enterEmailName(email);
        signInPage.enterEmailDomain(String.valueOf(StringGenerator.stringGenerate(3,"")));
        String password=String.valueOf(StringGenerator.passwordGenerate(10,email));
        signInPage.enterPassword(password);
        signInPage.selectDomainByIndex(3);
        signInPage.checkPolicy();
        signInPage.clickNextBTN();

        ThisIsMyPage thisIsMyPage=new ThisIsMyPage();
        Assert.assertTrue(thisIsMyPage.state().isDisplayed(),"this is my page is closed");
        thisIsMyPage.unselectAllCheckBox();
        thisIsMyPage.selectRandomCheckBox();
        thisIsMyPage.selectRandomCheckBox();
        thisIsMyPage.selectRandomCheckBox();
        thisIsMyPage.uploadPictureBTN("src/test/resources/AutoItScript1.exe");
        thisIsMyPage.clickToNextBTN();
        PersonalDetailsPage personalDetailsPage=new PersonalDetailsPage();
        Assert.assertTrue(personalDetailsPage.state().isDisplayed(),"personal page is not opened");

    }
}

