package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class OppenheimerUIPageObjects {

    @FindAll({@FindBy(xpath = "//input[@type='file']")})
    public WebElement browseBtn;

    @FindAll({@FindBy(xpath = "//button[text() = 'Refresh Tax Relief Table']")})
    public WebElement refreshButton;

    @FindAll({@FindBy(xpath = "//a[text() = 'Dispense Now']")})
    public WebElement dispenseNowBtn;

    @FindAll({@FindBy(xpath = "//div[text() = 'Cash dispensed']")})
    public WebElement cashDispensedText;

    @FindAll({@FindBy(xpath = "//table[contains(@class, 'table-dark')]")})
    public WebElement taxReleifTable;

    @FindAll({@FindBy(xpath = "//caption[text() = 'List of working class heroes and their tax relief']")})
    public WebElement taxReleifTableCaption;

    @FindAll({@FindBy(xpath = "//th[text() = 'NatId']")})
    public WebElement taxReleifTableNatidHeader;

    @FindAll({@FindBy(xpath = "//th[text() = 'Relief']")})
    public WebElement taxReleifTableReliefHeader;

}
