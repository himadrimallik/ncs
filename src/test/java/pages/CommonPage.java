package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.CommonPageObjects;

import static libraries.ElementWrappers.clickObject;
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
        Assert.assertTrue(isDisplayed(driver, commonPageObjects.landingPageLogo));
        Assert.assertTrue(isDisplayed(driver, commonPageObjects.landingPageHeader));
    }

    public void navigateToInsurance(String insuranceType){
        if (insuranceType.equalsIgnoreCase("Automobile")){
            clickObject(driver, commonPageObjects.automobileLink);
        }else if (insuranceType.equalsIgnoreCase("repos per week")){
            WebElement spLink = driver.findElement(By.xpath("//*[text() = '" + insuranceType + "']"));
            clickObject(driver, spLink);
        }else if (insuranceType.equalsIgnoreCase("events per week")){
            WebElement spLink = driver.findElement(By.xpath("//*[text() = '" + insuranceType + "']"));
            clickObject(driver, spLink);
        }

    }

}
