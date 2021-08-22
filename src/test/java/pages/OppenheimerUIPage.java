package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pageObjects.OppenheimerUIPageObjects;

import java.util.List;

import static libraries.ElementWrappers.*;

public class OppenheimerUIPage {

    OppenheimerUIPageObjects oppenheimerUIPageObjects;
    WebDriver driver;

    public OppenheimerUIPage(WebDriver driver) {
        this.driver = driver;
        oppenheimerUIPageObjects = new OppenheimerUIPageObjects();
        PageFactory.initElements(driver, oppenheimerUIPageObjects);
    }

    public void verifyAutomobileInsurantPage(){
        Assert.assertTrue(isDisplayed(driver, oppenheimerUIPageObjects.firstNameTextbox));

    }

    public void selectHobbies(String hobbies){
        List<WebElement> childElements = driver.findElements(By.name("Hobbies"));

        for (WebElement element: childElements) {
            if(element.getAttribute("value").equalsIgnoreCase(hobbies)){
                try {
                    element.click();
                }catch (Exception e){
                    element.sendKeys(Keys.ENTER);
                    element.sendKeys(Keys.SPACE);
                }
                break;
            }
        }
    }

}
