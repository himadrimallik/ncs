package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.OppenheimerUIPageObjects;

import static libraries.ElementWrappers.*;

public class OppenheimerUIPage {

    OppenheimerUIPageObjects oppenheimerUIPageObjects;
    WebDriver driver;

    public OppenheimerUIPage(WebDriver driver) {
        this.driver = driver;
        oppenheimerUIPageObjects = new OppenheimerUIPageObjects();
        PageFactory.initElements(driver, oppenheimerUIPageObjects);
    }

    public void uploadCSVFile(){
        String projectBasePath = libraries.Hooks.prop.getProperty("projectBasePath");
        String filePath = projectBasePath + "/src/test/resources/csv/oppenheimerCSV_SingleRecord.csv";

        oppenheimerUIPageObjects.browseBtn.sendKeys(filePath);
    }

    public void validateButtonColor(){
        waitForElement(driver, oppenheimerUIPageObjects.dispenseNowBtn);

        String colorCode = Color.fromString(oppenheimerUIPageObjects.dispenseNowBtn.getCssValue("background-color")).asHex();
        Assert.assertEquals(colorCode, "#dc3545");
    }

    public void validateButtonName(String buttonName){
        waitForElement(driver, oppenheimerUIPageObjects.dispenseNowBtn);

        Assert.assertEquals(oppenheimerUIPageObjects.dispenseNowBtn.getText(), buttonName);
    }

    public void clickButton(String buttonName){
        if(buttonName.equalsIgnoreCase("Dispense Now")){
            moveToElement(driver, oppenheimerUIPageObjects.dispenseNowBtn);
            clickObject(driver, oppenheimerUIPageObjects.dispenseNowBtn);
        }else if(buttonName.equalsIgnoreCase("Refresh Tax Relief Table")){
            moveToElement(driver, oppenheimerUIPageObjects.refreshButton);
            clickObject(driver, oppenheimerUIPageObjects.refreshButton);
        }
    }

    public void validateTaxReliefTable(){
        isDisplayed(driver, oppenheimerUIPageObjects.taxReleifTable);
        isDisplayed(driver, oppenheimerUIPageObjects.taxReleifTableCaption);
        isDisplayed(driver, oppenheimerUIPageObjects.taxReleifTableNatidHeader);
        isDisplayed(driver, oppenheimerUIPageObjects.taxReleifTableCaption);
    }

    public void validateCashDispensedPage(){
        isDisplayed(driver, oppenheimerUIPageObjects.cashDispensedText);
    }

}
