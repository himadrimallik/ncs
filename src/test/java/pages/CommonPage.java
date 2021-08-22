package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.CommonPageObjects;

import static libraries.ElementWrappers.isDisplayed;

public class CommonPage {

    CommonPageObjects commonPageObjects;
    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        commonPageObjects = new CommonPageObjects();
        PageFactory.initElements(driver, commonPageObjects);
    }

    public void verifyLandingPage(){
        Assert.assertTrue(isDisplayed(driver, commonPageObjects.landingPageHeader));
        Assert.assertTrue(isDisplayed(driver, commonPageObjects.browseCSV));
    }



}
