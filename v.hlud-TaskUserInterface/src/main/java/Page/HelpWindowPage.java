package Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpWindowPage extends Form {
    private static final By locator=By.xpath("//button[contains(@class,'help-form__send-to-bottom-button')]");
    private static final String name="Help page";
    private IButton helpHideBTN= AqualityServices
            .getElementFactory().getButton(By.xpath("//button[contains(@class,'help-form__send-to-bottom-button')]"),"hide button");


    public HelpWindowPage() {
        super(locator, name);
    }
    public void clickToHideForm(){
        helpHideBTN.click();
    }



}
