package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ValidateMainMenuPage extends UnitedBasePage{
    public ValidateMainMenuPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[id*='headerNav']")
    public List<WebElement> mainMenu;


}
