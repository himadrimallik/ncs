package stepDefinition;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libraries.BaseTest;
import pages.CommonPage;
import test.java.libraries.Hooks;

import java.io.IOException;

public class CommonStepDefs extends BaseTest {

    CommonPage commonPage;

    public CommonStepDefs() throws IOException {
//        setUpEnvironment("Chrome");
        commonPage = new CommonPage(driver);
    }

    @Given("I launch {string} application")
    public void i_launch_application_in_browser(String applicationName) throws IOException {
        if(applicationName.equalsIgnoreCase("Tricentis Vehicle Insurance")){
            driver.get(Hooks.prop.getProperty("tricentisVehicleInsuranceApplication"));
        }else if(applicationName.equalsIgnoreCase("SP Group")){
            driver.get(Hooks.prop.getProperty("spGroupApplication"));
        }

    }

    @Then("I should navigate to Landing page")
    public void i_should_navigate_to_landing_page() {
        commonPage.verifyLandingPage();
    }

    @Then("I close Application")
    public void i_close_application() {
//        driver.close();
//        cleanUpEnvironment();
    }

    @When("I click on {string} from Landing Page")
    public void i_click_on_from_landing_page(String string) {
        commonPage.navigateToInsurance(string);
    }

}
