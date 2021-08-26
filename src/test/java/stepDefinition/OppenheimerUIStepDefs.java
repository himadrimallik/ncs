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

    @Then("I should see red colored button")
    public void iShouldSeeRedColoredButton() {
        oppenheimerUIPage.validateButtonColor();
    }

    @Then("I should see {string} button")
    public void iShouldSeeButton(String buttonName) {
        oppenheimerUIPage.validateButtonName(buttonName);
    }

    @When("I click on {string} button")
    public void iClickOnButton(String buttonName) {
        oppenheimerUIPage.clickButton(buttonName);
    }

    @Then("I should see records")
    public void iShouldSeeRecords() {
        oppenheimerUIPage.validateTaxReliefTable();
    }

    @Then("I should navigate to Cash Dispensed page")
    public void iShouldNavigateToCashDispensedPage() {
        oppenheimerUIPage.validateCashDispensedPage();
    }

}
