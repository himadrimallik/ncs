package libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;

public class ElementWrappers {

    public static void clickObject(WebDriver driver, WebElement element){
        try {
            waitForElement(driver, element);
            element.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean isDisplayed(WebDriver driver, WebElement element){
        boolean isDisplayed = false;
        try {
            waitForElement(driver, element);
            isDisplayed = element.isDisplayed();
        }catch (Exception e){
            e.printStackTrace();
        }

        return isDisplayed;
    }

    public static void waitForElement(WebDriver driver, WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(BaseTest.syncTime));
            WebElement element1 = wait.until((Function<? super WebDriver, WebElement>) ExpectedConditions.visibilityOf(element));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void moveToElement(WebDriver driver, WebElement element){
        try {
            Actions actions = new Actions(driver);
            actions.moveToElement(element);
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
