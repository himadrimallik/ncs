package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import test.java.pageObjects.SelectPriceOptionPageObjects;

public class SelectPriceOptionPage {

    SelectPriceOptionPageObjects selectPriceOptionPageObjects;
    WebDriver driver;

    public SelectPriceOptionPage(WebDriver driver) {
        this.driver = driver;
        selectPriceOptionPageObjects = new SelectPriceOptionPageObjects();
        PageFactory.initElements(driver, selectPriceOptionPageObjects);
    }

}
