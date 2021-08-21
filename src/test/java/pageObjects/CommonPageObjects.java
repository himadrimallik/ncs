package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class CommonPageObjects {

    @FindAll({@FindBy(id = "tricentis_logo"), @FindBy(id = "search")})
    public WebElement landingPageLogo;

    @FindAll({@FindBy(id = "app_sub_title"), @FindBy(className = "subtitle")})
    public WebElement landingPageHeader;

    @FindAll({@FindBy(id = "nav_automobile")})
    public WebElement automobileLink;



}
