package Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {

    private final static String name = "main page";
    private static final By locator = By.xpath("//button[@class='start__button']");
    private final ILink linkForReddirect = AqualityServices.getElementFactory().getLink(By.xpath("//a[@class='start__link']"), "link 4 redirect to next page");

    public MainPage() {
        super(locator, name);
    }

    public void redirectToNextPage() {
        linkForReddirect.clickAndWait();

    }


}
