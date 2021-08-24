package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class OppenheimerUIPageObjects {

    @FindAll({@FindBy(className = "custom-file-label")})
    public WebElement browseBtn;

    @FindAll({@FindBy(xpath = "//a[href = 'dispense']")})
    public WebElement dispenseNowBtn;

}
