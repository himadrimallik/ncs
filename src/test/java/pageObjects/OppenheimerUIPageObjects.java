package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class OppenheimerUIPageObjects {

    @FindAll({@FindBy(id = "firstname")})
    public WebElement firstNameTextbox;

    @FindAll({@FindBy(id = "lastname")})
    public WebElement lastNameTextbox;

    @FindAll({@FindBy(id = "opendateofbirthcalender")})
    public WebElement openDateOfBirthCalenderButton;

    @FindAll({@FindBy(id = "birthdate")})
    public WebElement birthDateTextbox;

    @FindAll({@FindBy(className = "group")})
    public WebElement genderRadioGroup;

    @FindAll({@FindBy(id = "streetaddress")})
    public WebElement streetAddressTextbox;

    @FindAll({@FindBy(id = "country")})
    public WebElement countryDropdown;

    @FindAll({@FindBy(id = "zipcode")})
    public WebElement zipCodeTextbox;

    @FindAll({@FindBy(id = "city")})
    public WebElement cityTextbox;

    @FindAll({@FindBy(id = "occupation")})
    public WebElement occupationDropdown;

    @FindAll({@FindBy(name = "Hobbies")})
    public WebElement hobbiesSelectionbox;

    @FindAll({@FindBy(id = "website")})
    public WebElement websiteTextbox;

    @FindAll({@FindBy(id = "open")})
    public WebElement openButton;

    @FindAll({@FindBy(id = "picture")})
    public WebElement pictureTextbox;

    @FindAll({@FindBy(id = "preventervehicledata")})
    public WebElement previousButton;

    @FindAll({@FindBy(id = "nextenterproductdata")})
    public WebElement nextButton;

}
