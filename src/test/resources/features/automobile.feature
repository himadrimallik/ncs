@AutomobileInsurance
Feature: Verify Automobile Insurance in Tricentis Demo App

  @AutomobileInsurance_Valid
  Scenario: Verify Valid Automobile Insurance
    Given I launch "Tricentis Vehicle Insurance" application
    Then I should navigate to Landing page
    When I click on "Automobile" from Landing Page
    Then I should navigate to "Automobile" page
    When I submit "valid" details for "Automobile" insurance
    Then I should navigate to Insurant Data page for "Automobile" insurance
    When I submit Insurant data with "valid" details for "Automobile" insurance
    Then I should navigate to Product Data page for "Automobile" insurance
    When I submit Product data with "valid" details for "Automobile" insurance
    Then I should navigate to Select Price Option page for "Automobile" insurance
    When I submit Price Option with "valid" details for "Automobile" insurance
    Then I should navigate to Send Quote page for "Automobile" insurance
    Then I close Application
