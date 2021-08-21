package stepDefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libraries.BaseTest;
import test.java.pages.ProductDataPage;

public class ProductDataStepDefs extends BaseTest {

    ProductDataPage productDataPage;

    public ProductDataStepDefs() {
        productDataPage = new ProductDataPage(driver);
    }

    @Then("I should navigate to Product Data page for {string} insurance")
    public void i_should_navigate_to_product_data_page_for_insurance(String string) {

    }

    @When("I submit Product data with {string} details for {string} insurance")
    public void i_submit_product_data_with_details_for_insurance(String string, String string2) {

    }

}
