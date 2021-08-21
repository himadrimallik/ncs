package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libraries.BaseTest;
import pages.VehicleDataPage;

import java.io.IOException;

public class VehicleDataStepDefs extends BaseTest {

    VehicleDataPage vehicleDataPage;

    public VehicleDataStepDefs() throws IOException {
        vehicleDataPage = new VehicleDataPage(driver);
    }

    @Then("I should navigate to {string} page")
    public void i_should_navigate_to_page(String string) {
        vehicleDataPage.verifyVehicleDataPage(string);
    }

    @When("I submit {string} details for {string} insurance")
    public void i_submit_details_for_insurance(String string, String vehicleType) {
        if (string.equalsIgnoreCase("valid")){
            vehicleDataPage.enterValidVehicleData(vehicleType);
        }
    }

}
