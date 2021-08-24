package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.OppenheimerAPIPage;

public class OppenheimerAPIStepDefs {

    OppenheimerAPIPage oppenheimerAPIPage;
    public OppenheimerAPIStepDefs() {
        oppenheimerAPIPage = new OppenheimerAPIPage();
    }

    @When("I insert a {string} record of working class hero into database via an API")
    public void iInsertARecordOfWorkingClassHeroIntoDatabaseViaAnAPI(String recordType) {
        oppenheimerAPIPage.insertRecord(recordType);
    }

    @When("I perform {string} with API")
    public void iPerformWithAPI(String operationType) {
        if(operationType.equalsIgnoreCase("Tax Relief")){
            oppenheimerAPIPage.callGetTaxReliefAPI();
        }
    }

    @Then("I should see a list consist of natid, tax relief amount and name is returned")
    public void iShouldSeeAListConsistOfNatidTaxReliefAmountAndNameIsReturned() {
        oppenheimerAPIPage.validateGetTaxReliefAPIFields();
    }

    @Then("I should see natid is masked")
    public void iShouldSeeNatidIsMasked() {
        oppenheimerAPIPage.validateNatidMasked();
    }

    @Then("I should see tax relief is calculated properly")
    public void iShouldSeeTaxReliefIsCalculatedProperly() {
        oppenheimerAPIPage.validateTaxReliefCalculation();
    }

    @Then("I should see tax relief is rounded")
    public void iShouldSeeTaxReliefIsRounded() {
        oppenheimerAPIPage.validateRounding();
    }

    @Then("I should see tax relief is {int}")
    public void iShouldSeeTaxReliefIs(int taxAmount) {
        oppenheimerAPIPage.validateTaxReliefRoundedToFifty(taxAmount);
    }

    @Then("I should see tax relief decimal places are truncated to {int} places")
    public void iShouldSeeTaxReliefDecimalPlacesAreTruncatedToPlaces(int decimalPlaces) {
        oppenheimerAPIPage.validateRoundingTruncate(decimalPlaces);
    }

    @Then("I should get {string} success response")
    public void iShouldGetSuccessResponse(String response) {
        oppenheimerAPIPage.verifyResponse(response);
    }
}
