package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import test.java.pageObjects.ProductDataPageObjects;

public class ProductDataPage {

    ProductDataPageObjects productDataPageObjects;
    WebDriver driver;

    public ProductDataPage(WebDriver driver) {
        this.driver = driver;
        productDataPageObjects = new ProductDataPageObjects();
        PageFactory.initElements(driver, productDataPageObjects);
    }

}
