package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CSVPage;

public class CSVStepDefs {

    CSVPage csvPage;

    public CSVStepDefs() {
        csvPage = new CSVPage();
    }

    @When("I open {string} CSV file")
    public void iOpenCSVFile(String fileType) {
        csvPage.openCSVFile(fileType);
    }

    @Then("I should see header in first row")
    public void iShouldSeeHeaderInFirstRow() {
        csvPage.verifyHeader();
    }

    @Then("I should see data in subsequent row")
    public void iShouldSeeDataInSubsequentRow() {
        csvPage.verifyRecords();
    }
}
