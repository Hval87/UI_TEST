package Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class SignInPage extends Form {

    private static By locator = By.xpath("//div[@class='login-form']");
    private static String name = "sign in page";
    private ITextBox password = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "password input");
    private ITextBox emailName = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[@placeholder='Your email']"), "email name");
    private ITextBox emailDomain = AqualityServices.getElementFactory().getTextBox(By.xpath("//input[@placeholder='Domain']"), "email domain");
    private ILabel emailCountry = AqualityServices.getElementFactory().getLabel(By.xpath("//span[contains(@class,'icon icon-chevron-down')]"), "email dropdown");
    private ICheckBox acceptBox = AqualityServices.getElementFactory().getCheckBox(By.xpath("//span[contains(@class,'checkbox__check')]"), "accept checkbox");
    private IButton nextBTN = AqualityServices.getElementFactory().getButton(By.xpath("//a[@class='button--secondary']"), "next button");
    private ILabel clockLabel=AqualityServices.getElementFactory().getLabel(By.xpath("//div[@class='timer timer--white timer--center']"),"clock label");
    private PopUpCookiePage popUpCookiePage;
    public SignInPage() {

        super(locator, name);
    }

    public void enterPassword(String text) {
        password.clearAndTypeSecret(text);
    }

    public void enterEmailName(String text) {
        emailName.clearAndType(text);
    }

    public void enterEmailDomain(String text) {
        emailDomain.clearAndType(text);
    }

    public void selectDomainByIndex(int index) {
        emailCountry.click();
        AqualityServices.getElementFactory()
                .findElements(By.xpath("//div[@class='dropdown__list-item']"), ElementType.LABEL)
                .get(index).click();
    }

    public void checkPolicy() {
        acceptBox.check();
    }

    public void clickNextBTN() {
        nextBTN.click();
    }
    public void clickAcceptCookie(){
        popUpCookiePage=new PopUpCookiePage();
        popUpCookiePage.clickAcceptCoocie();
    }
    public boolean isWindowCookieDisplayed(){
        return popUpCookiePage.state().isDisplayed();
    }
    public String getClockText(){
       return clockLabel.getText();


    }

}
