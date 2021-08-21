package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import test.java.pageObjects.VehicleDataPageObjects;
import testDataReader.VehicleTestData;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import static libraries.ElementWrappers.*;

public class VehicleDataPage {

    WebDriver driver;
    VehicleDataPageObjects vehicleDataPageObjects;
    VehicleTestData vehicleTestData;
    Map<String, Object> testdata;

    public VehicleDataPage(WebDriver driver) throws FileNotFoundException {
        this.driver = driver;
        vehicleDataPageObjects = new VehicleDataPageObjects();
        PageFactory.initElements(driver, vehicleDataPageObjects);

        vehicleTestData = new VehicleTestData();
        testdata = vehicleTestData.readTestData();
    }

    public void verifyVehicleDataPage(String vehicleType){
        if (vehicleType.equalsIgnoreCase("Automobile")){
            verifyAutomobileDataPage();
        }else {
            if (vehicleType.equalsIgnoreCase("repos per week")) {
            }
            verifySPGroupPage(vehicleType);
        }
    }

    public void verifyAutomobileDataPage(){
        Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.vehiclePageLink));
        Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.makeDropdown));
        Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.enginePerformanceTextbox));
        Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.openDateOfManufactureCalenderButton));
        Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.openDateOfManufactureCalenderTextbox));
        Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.numberOfSeatsDropdown));
        Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.fuelDropdown));
        Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.listPriceTextbox));
        Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.licensePlateNumberTextbox));
        Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.annualMileageTextbox));
        Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.nextEnterInsurantDataButton));
    }

    public void enterValidVehicleData(String vehicleType){
        if (vehicleType.equalsIgnoreCase("Automobile")){
            enterAutomobileData();
        }
    }

    public void enterAutomobileData(){

        List<Map<String, Object>> vehicleDetails = (List<Map<String, Object>>) testdata.get("vehicleDetails");
        int testdataIndex = 0;

        selectValue(driver, vehicleDataPageObjects.makeDropdown, vehicleDetails.get(testdataIndex).get("make").toString());
        enterText(driver, vehicleDataPageObjects.enginePerformanceTextbox, vehicleDetails.get(testdataIndex).get("performance").toString());
        enterText(driver, vehicleDataPageObjects.openDateOfManufactureCalenderTextbox, vehicleDetails.get(testdataIndex).get("openDateOfManufacture").toString());
        selectValue(driver, vehicleDataPageObjects.numberOfSeatsDropdown, vehicleDetails.get(testdataIndex).get("numberOfSeats").toString());
        selectValue(driver, vehicleDataPageObjects.fuelDropdown, vehicleDetails.get(testdataIndex).get("fuel").toString());
        enterText(driver, vehicleDataPageObjects.listPriceTextbox, vehicleDetails.get(testdataIndex).get("listPrice").toString());
        enterText(driver, vehicleDataPageObjects.licensePlateNumberTextbox, vehicleDetails.get(testdataIndex).get("licenseNumberPlate").toString());
        enterText(driver, vehicleDataPageObjects.annualMileageTextbox, vehicleDetails.get(testdataIndex).get("annualMileage").toString());
        clickObject(driver, vehicleDataPageObjects.nextEnterInsurantDataButton);

    }

    public void verifySPGroupPage(String linkName){
        if(linkName.equalsIgnoreCase("repos per week")){
            Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.reposPerWeekTitle));
        }else if(linkName.equalsIgnoreCase("events per week")){
            Assert.assertTrue(isDisplayed(driver, vehicleDataPageObjects.eventsPerWeekTitle));
        }

    }

}
