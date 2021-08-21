
package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import libraries.BaseTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;

@CucumberOptions(
        monochrome = true,
        glue = "stepDefinition"
        )

public class TestRunner extends BaseTest {

       private TestNGCucumberRunner testNGCucumberRunner;

//    public static RemoteWebDriver connection;

        @Parameters({"features", "browser","tags"})
        @BeforeClass(alwaysRun = true)
        public void setUpCucumber(String features,String browser,String tags) throws NoSuchFieldException, IllegalAccessException {

            browserName = browser; //prop.getProperty("browser");

            if(browserName.equalsIgnoreCase("Chrome")){
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                driver = new ChromeDriver();
            }else if(browserName.equalsIgnoreCase("IE")){
                System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
                driver = new InternetExplorerDriver();
            }else if(browserName.equalsIgnoreCase("Firefox")){
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }

            driver.manage().window().maximize();

            Class<?> testClass = this.getClass();
            changeCucumberAnnotation(testClass, "features", new String[]{features});
            changeCucumberAnnotation(testClass, "tags", new String[]{tags});
            testNGCucumberRunner = new TestNGCucumberRunner(testClass);
        }

        @Test(groups = "cucumber", description = "Selenium Cucumber TestNG Suite", dataProvider = "scenarios")
        public void scenario(PickleEventWrapper pickleEventWrapper, CucumberFeatureWrapper cucumberFeatureWrapper) throws Throwable {
            testNGCucumberRunner.runScenario(pickleEventWrapper.getPickleEvent());
        }

        @DataProvider
        public Object[][] scenarios() {
            return testNGCucumberRunner.provideScenarios();
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass() throws Exception {
            testNGCucumberRunner.finish();
        }

        private static void changeCucumberAnnotation(Class<?> clazz, java.lang.String key, Object value) throws IllegalAccessException, NoSuchFieldException {
            Annotation options = clazz.getAnnotation(CucumberOptions.class);
            InvocationHandler proxyHandler = Proxy.getInvocationHandler(options);
            Field f = proxyHandler.getClass().getDeclaredField("memberValues");
            f.setAccessible(true);
            Map<String, Object> memberValues = (Map<String, Object>) f.get(proxyHandler);
            memberValues.remove(key);
            memberValues.put(key, value);
        }

}
