package test.java.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import test.java.pageObjects.SendQuotePageObjects;

public class SendQuotePage {

    SendQuotePageObjects sendQuotePageObjects;
    WebDriver driver;

    public SendQuotePage(WebDriver driver) {
        this.driver = driver;
        sendQuotePageObjects = new SendQuotePageObjects();
        PageFactory.initElements(driver, sendQuotePageObjects);
    }

}
