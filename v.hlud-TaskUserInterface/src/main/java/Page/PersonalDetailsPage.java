package Page;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsPage extends Form {

    private static By locator=By.xpath("//div[@class='personal-details__form']");
    private static String name="personal details page";
    public PersonalDetailsPage() {
        super(locator, name);
    }


}
