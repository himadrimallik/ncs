package stepDefinition;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import libraries.BaseTest;
import libraries.Hooks;
import pages.CommonPage;

import java.io.IOException;

public class CommonStepDefs extends BaseTest {

    CommonPage commonPage;

    public CommonStepDefs() throws IOException {
        commonPage = new CommonPage(driver);
    }

    @Given("I launch Oppenheimer application")
    public void iLaunchOppenheimerApplication() throws IOException {
        driver.get(Hooks.prop.getProperty("oppenheimerUIApplication"));
    }

    @Then("I should navigate to Landing page")
    public void iShouldNavigateToLandingPage() {
        commonPage.verifyLandingPage();
    }

    @Given("I have CSV file")
    public void iHaveCSVFile() {
        commonPage.verifyCSVFileExistence();
    }

    @Given("I launch application via API")
    public void iLaunchApplicationViaAPI() {
        commonPage.verifyBaseAPIExistence();
    }

}
