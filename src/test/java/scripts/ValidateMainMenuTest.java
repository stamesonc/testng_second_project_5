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

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1, description = "Validate Main Menu")
    public void validateMainMenu(){

        String[] mainMenuText = {"Book", "MY TRIPS", "TRAVEL INFO", "MILEAGEPLUS® PROGRAM", "DEALS", "HELP"};

        for (int i = 0; i < 6; i++) {
            Assert.assertTrue(validateMainMenuPage.mainMenu.get(i).isDisplayed());
            Assert.assertEquals(validateMainMenuPage.mainMenu.get(i).getText(),mainMenuText);

        }
    }


    @Test(priority = 2, description = "Validate Book travel menu navigation items")
    public void validateBookTravelMenu(){
        String[] str = {"Book", "Flight status", "Check-in", "My trips"};
        for (int i = 0; i < str.length; i++) {
            Assert.assertTrue(validateMainMenuPage.bookTravelTabs.get(i).isDisplayed());
            Assert.assertEquals(validateMainMenuPage.bookTravelTabs.get(i).getText(), str[i]);

        }
    }


    @Test(priority = 3, description = "Validate Round-trip and One-way radio buttons")
    public void validateroundTripButtonAndoneWayButtonButtons(){
        Assert.assertTrue(validateMainMenuPage.roundTripDisplay.isDisplayed());
        Assert.assertTrue(validateMainMenuPage.roundTripButton.isEnabled());
        Assert.assertTrue(validateMainMenuPage.roundTripButton.isSelected());
        Assert.assertTrue(validateMainMenuPage.oneWayDisplay.isDisplayed());
        Assert.assertTrue(validateMainMenuPage.oneWayButton.isEnabled());
        Assert.assertFalse(validateMainMenuPage.oneWayButton.isSelected());
        validateMainMenuPage.oneWayButton.click();
        Assert.assertTrue(validateMainMenuPage.oneWayButton.isSelected());
        Assert.assertFalse(validateMainMenuPage.roundTripButton.isSelected());

    }


    @Test(priority = 4, description = "Validate Book with miles and Flexible dates checkboxes")
    public void validateBookAndFlexibleCheckboxes(){
        Assert.assertTrue(validateMainMenuPage.bookWithMilesCheckbox.isDisplayed());
        Assert.assertTrue(validateMainMenuPage.bookWithMilesCheckbox.isEnabled());
        Assert.assertFalse(validateMainMenuPage.bookWithMilesCheckboxSelect.isSelected());

        Assert.assertTrue(validateMainMenuPage.flexibleDatesCheckbox.isDisplayed());
        Assert.assertTrue(validateMainMenuPage.flexibleDatesCheckbox.isEnabled());
        Assert.assertFalse(validateMainMenuPage.flexibleDatesCheckboxSelect.isSelected());

        validateMainMenuPage.bookWithMilesCheckbox.click();
        validateMainMenuPage.flexibleDatesCheckbox.click();

        Assert.assertTrue(validateMainMenuPage.bookWithMilesCheckboxSelect.isSelected());
        Assert.assertTrue(validateMainMenuPage.flexibleDatesCheckboxSelect.isSelected());

        validateMainMenuPage.bookWithMilesCheckbox.click();
        validateMainMenuPage.flexibleDatesCheckbox.click();

        Assert.assertFalse(validateMainMenuPage.bookWithMilesCheckboxSelect.isSelected());
        Assert.assertFalse(validateMainMenuPage.flexibleDatesCheckboxSelect.isSelected());

    }

    @Test(priority = 5, description = "Validate One-way ticket search results from Chicago, IL, US (ORD) to Miami, FL, US (MIA)")
    public void validateTicketSearchResults(){

        validateMainMenuPage.oneWayButton.click();
        validateMainMenuPage.fromButton.click();
        validateMainMenuPage.clearFromButton.click();
        validateMainMenuPage.fromButton.click();
        validateMainMenuPage.fromButton.sendKeys("Chicago, IL, US (ORD)");
        validateMainMenuPage.toButton.sendKeys("Miami, FL, US (MIA)");
        validateMainMenuPage.departDateButton.click();
        validateMainMenuPage.previousMonthButton.click();
        validateMainMenuPage.dateInput.click();
        validateMainMenuPage.passengerButton.click();
        validateMainMenuPage.addAnAdult.click();
        Waiter.pause(1);
        validateMainMenuPage.selectClassButton.click();
        validateMainMenuPage.selectBusinessOrFirstClass.click();
        validateMainMenuPage.findFlightsButton.click();
        Assert.assertEquals(validateMainMenuPage.departureDetails.getText(), "DEPART ON: February 28");



}}
