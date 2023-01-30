package Page;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.CheckBox;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class ThisIsMyPage extends Form {

    private static By locator = By.xpath("//div[@class='avatar-and-interests']");
    private static String name = "Page about me";
    private ILink uploadBTN = AqualityServices.getElementFactory()
            .getLink(By.xpath("//a[contains(@class,'upload-button')]"), "upload button");
    private IButton nextBTN = AqualityServices.getElementFactory()
            .getButton(By.xpath("//button[contains(@class,' button--stroked ')]"), "next button");

    public ThisIsMyPage() {
        super(locator, name);
    }

    public void unselectAllCheckBox() {
        List<CheckBox> list = AqualityServices
                .getElementFactory().findElements(By.xpath("//span[@class='checkbox small']"), ElementType.CHECKBOX);
        list.get(list.size() - 1).click();
    }

    public void selectRandomCheckBox() {
        List<CheckBox> list = AqualityServices
                .getElementFactory().findElements(By.xpath("//span[@class='checkbox small']"), ElementType.CHECKBOX);
        int indexOfBox = (int) (Math.random() * (((list.size() - 1) - 0) + 1));
        CheckBox tmpBox = list.get(indexOfBox);
        if (indexOfBox != list.size() - 1 && indexOfBox != 17 && !tmpBox.isChecked()) {
            tmpBox.check();
        } else {
            System.out.println("repeat method");
            this.selectRandomCheckBox();
        }
    }

    public void uploadPictureBTN(String source) {
        uploadBTN.clickAndWait();
        try {
            Thread.sleep(1000);
            Runtime.getRuntime().exec(source);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void clickToNextBTN() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AqualityServices.getConditionalWait().waitFor(() -> nextBTN.state().isClickable());
        nextBTN.click();
    }
}
