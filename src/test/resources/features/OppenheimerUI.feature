@Oppenheimer_UI
Feature: As the Clerk, I should be able to insert a single record of working class hero into database via an API

  @Oppenheimer_US2 @Oppenheimer_US2_AC1
  Scenario: Verify As the Clerk, I should be able to insert more than one working class hero into database via an API
    Given I launch Oppenheimer application
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

