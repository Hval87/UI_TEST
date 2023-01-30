package Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PopUpCookiePage extends Form {
    private static By locator=By.xpath("//div[@class='cookies']");
    private static String name="pop up window for cookie";
    private IButton acceptCoocieBTN= AqualityServices.getElementFactory()
            .getButton(By.xpath("//button[@class='button button--solid button--transparent' and contains(text(),'Not really, no')]"),"button accept coocie");

    protected PopUpCookiePage() {
        super(locator, name);
    }

    public void clickAcceptCoocie(){
        acceptCoocieBTN.click();
    }


}
