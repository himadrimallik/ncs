package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libraries.BaseTest;
import pages.InsurantDataPage;

import java.io.IOException;

public class InsurantDataStepDefs extends BaseTest {

    InsurantDataPage insurantDataPage;

    public InsurantDataStepDefs() throws IOException {
        insurantDataPage = new InsurantDataPage(driver);
    }

    @Then("I should navigate to Insurant Data page for {string} insurance")
    public void i_should_navigate_to_insurant_data_page_for_insurance(String string) {
        if (string.equalsIgnoreCase("Automobile")){
            insurantDataPage.verifyAutomobileInsurantPage();
        }
    }

    @When("I submit Insurant data with {string} details for {string} insurance")
    public void i_submit_insurant_data_with_details_for_insurance(String string, String string2) {
        if (string2.equalsIgnoreCase("Automobile")){
            if (string.equalsIgnoreCase("valid")){
                insurantDataPage.enterValidAutomobileInsurantData();
            }
        }
    }

}