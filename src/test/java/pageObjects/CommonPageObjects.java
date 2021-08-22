package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class CommonPageObjects {

    @FindAll({@FindBy(xpath = "//*[text() = 'The Oppenheimer Project']")})
    public WebElement landingPageHeader;

    @FindAll({@FindBy(className = "custom-file-input")})
    public WebElement browseCSV;



}
