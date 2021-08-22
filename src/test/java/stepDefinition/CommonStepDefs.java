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
        commonPage = new CommonPage(driver);
    }

    @Given("I launch Oppenheimer application")
    public void i_launch_application_in_browser() throws IOException {
        driver.get(Hooks.prop.getProperty("oppenheimerUIApplication"));
    }

    @Then("I should navigate to Landing page")
    public void i_should_navigate_to_landing_page() {
        commonPage.verifyLandingPage();
    }

    @Then("I close Application")
    public void i_close_application() {

    }

    @When("I click on {string} from Landing Page")
    public void i_click_on_from_landing_page(String string) {
        commonPage.navigateToInsurance(string);
    }

}
