package test.java.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class VehicleDataPageObjects {

    @FindAll({@FindBy(id = "selectedinsurance")})
    public WebElement vehiclePageLink;

    @FindAll({@FindBy(id = "make")})
    public WebElement makeDropdown;

    @FindAll({@FindBy(id = "engineperformance")})
    public WebElement enginePerformanceTextbox;

    @FindAll({@FindBy(id = "opendateofmanufacturecalender")})
    public WebElement openDateOfManufactureCalenderButton;

    @FindAll({@FindBy(id = "dateofmanufacture")})
    public WebElement openDateOfManufactureCalenderTextbox;

    @FindAll({@FindBy(id = "numberofseats")})
    public WebElement numberOfSeatsDropdown;

    @FindAll({@FindBy(id = "fuel")})
    public WebElement fuelDropdown;

    @FindAll({@FindBy(id = "listprice")})
    public WebElement listPriceTextbox;

    @FindAll({@FindBy(id = "licenseplatenumber")})
    public WebElement licensePlateNumberTextbox;

    @FindAll({@FindBy(id = "annualmileage")})
    public WebElement annualMileageTextbox;

    @FindAll({@FindBy(id = "nextenterinsurantdata")})
    public WebElement nextEnterInsurantDataButton;

    @FindAll({@FindBy(xpath = "//*[text()='repositories updated per week']")})
    public WebElement reposPerWeekTitle;

    @FindAll({@FindBy(xpath = "//*[text()='events per week']")})
    public WebElement eventsPerWeekTitle;

}
