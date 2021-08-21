package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libraries.BaseTest;
import test.java.pages.SelectPriceOptionPage;

public class SelectPriceOptionStepDefs extends BaseTest {

    SelectPriceOptionPage selectPriceOptionPage;

    public SelectPriceOptionStepDefs () {
        selectPriceOptionPage = new SelectPriceOptionPage(driver);
    }

    @When("I submit Price Option with {string} details for {string} insurance")
    public void i_submit_price_option_with_details_for_insurance(String string, String string2) {

    }

    @Then("I should navigate to Select Price Option page for {string} insurance")
    public void i_should_navigate_to_select_price_option_page_for_insurance(String string) {

    }

}
