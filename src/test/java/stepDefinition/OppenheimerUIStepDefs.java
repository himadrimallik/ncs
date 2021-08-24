package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libraries.BaseTest;
import pages.OppenheimerUIPage;

import java.io.IOException;

public class OppenheimerUIStepDefs extends BaseTest {

    OppenheimerUIPage oppenheimerUIPage;

    public OppenheimerUIStepDefs() throws IOException {
        oppenheimerUIPage = new OppenheimerUIPage(driver);
    }

    @When("I upload csv file")
    public void iUploadCsvFile() {
        oppenheimerUIPage.uploadCSVFile();
    }

    @When("I should navigate to Dispense Tax Relief page")
    public void iShouldNavigateToDispenseTaxReliefPage() {
    }

    @Then("I should see red colored button")
    public void iShouldSeeRedColoredButton() {
    }

    @Then("I should see {string} button")
    public void iShouldSeeButton(String arg0) {
    }

    @When("I click on {string} button")
    public void iClickOnButton(String arg0) {
    }

    @Then("I should navigate to Cash Dispensed page")
    public void iShouldNavigateToCashDispensedPage() {

    }

    @Then("I should see records")
    public void iShouldSeeRecords() {
    }
}
