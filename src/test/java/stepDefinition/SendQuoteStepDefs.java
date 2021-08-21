package stepDefinition;

import cucumber.api.java.en.Then;
import libraries.BaseTest;
import test.java.pages.SendQuotePage;

public class SendQuoteStepDefs extends BaseTest {

    SendQuotePage sendQuotePage;

    public SendQuoteStepDefs() {
        sendQuotePage = new SendQuotePage(driver);
    }

    @Then("I should navigate to Send Quote page for {string} insurance")
    public void i_should_navigate_to_send_quote_page_for_insurance(String string) {

    }
}
