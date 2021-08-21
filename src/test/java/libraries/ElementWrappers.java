package libraries;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
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

    public static String readText(WebDriver driver, WebElement element){
        String text = "";
        try {
            waitForElement(driver, element);
            text = element.getAttribute("text");
        }catch (Exception e){
            e.printStackTrace();
        }
        return text;
    }

    public static void enterText(WebDriver driver, WebElement element, String text){
        try {
            waitForElement(driver, element);
            element.sendKeys(text);
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

    public static void selectValue(WebDriver driver, WebElement element, String text){
        try {
            waitForElement(driver, element);
            element.sendKeys(text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void selectRadio(WebDriver driver, By by, String id){
        try {
            List<WebElement> childElements = driver.findElements(by);

            for (WebElement element: childElements) {
                if(element.getAttribute("id").equalsIgnoreCase(id)){
                    try {
                        element.click();
                    }catch (Exception e){
                        element.sendKeys(Keys.ENTER);
                        element.sendKeys(Keys.SPACE);
                    }
                    break;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
