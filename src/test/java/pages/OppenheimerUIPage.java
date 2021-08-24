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

    public void uploadCSVFile(){
        Assert.assertTrue(isDisplayed(driver, oppenheimerUIPageObjects.browseBtn));

        WebElement browse = driver.findElement(By.xpath("//input[@class='custom-file-input']"));
        //click on ‘Choose file’ to upload the desired file

        String projectBasePath = libraries.Hooks.prop.getProperty("projectBasePath");
        String filePath = projectBasePath + "/src/test/resources/csv/oppenheimerCSV_SingleRecord.csv";

        browse.sendKeys(filePath);

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
