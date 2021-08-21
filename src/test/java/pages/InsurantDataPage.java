package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.InsurantDataPageObjects;

import java.util.List;

import static libraries.ElementWrappers.*;

public class InsurantDataPage {

    InsurantDataPageObjects insurantDataPageObjects;
    WebDriver driver;

    public InsurantDataPage(WebDriver driver) {
        this.driver = driver;
        insurantDataPageObjects = new InsurantDataPageObjects();
        PageFactory.initElements(driver, insurantDataPageObjects);
    }

    public void verifyAutomobileInsurantPage(){
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.firstNameTextbox));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.lastNameTextbox));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.openDateOfBirthCalenderButton));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.birthDateTextbox));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.genderRadioGroup));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.streetAddressTextbox));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.countryDropdown));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.zipCodeTextbox));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.cityTextbox));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.occupationDropdown));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.hobbiesSelectionbox));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.websiteTextbox));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.openButton));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.pictureTextbox));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.previousButton));
        Assert.assertTrue(isDisplayed(driver, insurantDataPageObjects.nextButton));
    }

    public void enterValidAutomobileInsurantData(){
        enterText(driver, insurantDataPageObjects.firstNameTextbox, "FirstName");
        enterText(driver, insurantDataPageObjects.lastNameTextbox, "LastName");
        enterText(driver, insurantDataPageObjects.birthDateTextbox, "12/12/1990");
        selectRadio(driver, By.xpath("//div[@class='field']/p/label/input"), "gendermale");
        enterText(driver, insurantDataPageObjects.streetAddressTextbox, "Test 123 Road");
        selectValue(driver, insurantDataPageObjects.countryDropdown, "Singapore");
        enterText(driver, insurantDataPageObjects.zipCodeTextbox, "760289");
        enterText(driver, insurantDataPageObjects.cityTextbox, "Singapore");
        selectValue(driver, insurantDataPageObjects.occupationDropdown, "Employee");
        selectHobbies("Skydiving");

    }

    public void selectHobbies(String hobbies){
        List<WebElement> childElements = driver.findElements(By.name("Hobbies"));

        for (WebElement element: childElements) {
            if(element.getAttribute("value").equalsIgnoreCase(hobbies)){
                try {
                    element.click();
                }catch (Exception e){
                    element.sendKeys(Keys.ENTER);
                    element.sendKeys(Keys.SPACE);
                }
                break;
            }
        }
    }

}
