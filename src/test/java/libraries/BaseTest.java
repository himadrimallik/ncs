package libraries;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import static libraries.Hooks.loadConfigFiles;
import static libraries.Hooks.prop;


public class BaseTest {

    public static WebDriver driver;
    public static String syncTime;
    public String browserName;


    @BeforeSuite
    public void setUpEnvironment() throws IOException {

        loadConfigFiles();
        syncTime = prop.getProperty("syncTimeout");

    }

    @AfterSuite
    public void cleanUpEnvironment(){
        if(driver != null){
            driver.close();
            driver.quit();
        }
    }

}
