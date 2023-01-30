package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.UnitedBasePage;
import utilities.Waiter;

public class ValidateMainMenuTest extends UnitedBase{



    @BeforeMethod
    public void setPage(){
        unitedBasePage = new UnitedBasePage();

    }

    @Test(priority = 1, description = "Validate Main Menu")
    public void validateMainMenu(){

        String[] mainMenuText = {"Book", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};

        for (int i = 0; i < 6; i++) {
            Assert.assertTrue(validateMainMenuPage.mainMenu.get(i).isDisplayed());
            Assert.assertEquals(validateMainMenuPage.mainMenu.get(i).getText(),mainMenuText);

        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
