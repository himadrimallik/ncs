package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.CommonPageObjects;
import libraries.Hooks;

import java.io.File;

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
    }

    public void verifyCSVFileExistence(){
        String projectBasePath = libraries.Hooks.prop.getProperty("projectBasePath");
        File singleRecordCSV = new File(projectBasePath + "/src/test/resources/csv/oppenheimerCSV_SingleRecord.csv");
        File multipleRecordsCSV = new File(projectBasePath + "/src/test/resources/csv/oppenheimerCSV_MultipleRecords.csv");

        Assert.assertTrue(singleRecordCSV.exists());
        Assert.assertTrue(multipleRecordsCSV.exists());
    }

    public void verifyBaseAPIExistence(){
        Assert.assertFalse(Hooks.prop.getProperty("oppenheimerBaseAPI").isEmpty());
    }

}
