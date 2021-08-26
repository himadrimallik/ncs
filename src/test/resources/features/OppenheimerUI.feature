@Oppenheimer_UI
Feature: Verify Oppenheimer project via UI

  @Oppenheimer_US3 @Oppenheimer_US3_AC1
  Scenario: Verify header row of csv file
    Given I have CSV file
    When I open "single record" CSV file
    Then I should see header in first row

  @Oppenheimer_US3 @Oppenheimer_US3_AC2
  Scenario: Verify subsequent row of csv file
    Given I have CSV file
    When I open "multiple record" CSV file
    Then I should see data in subsequent row

  @Oppenheimer_US3 @Oppenheimer_US3_AC3
  Scenario: Verify As the Clerk, I should be able to upload a csv file to a portal so that I can populate the database from a UI
    Given I launch Oppenheimer application
    Then I should navigate to Landing page
    When I upload csv file
    And I click on "Refresh Tax Relief Table" button
    Then I should see records

  @Oppenheimer_US5 @Oppenheimer_US5_AC1
  Scenario: Verify colour of dispense tax relief button
    Given I launch Oppenheimer application
    Then I should navigate to Landing page
    Then I should see red colored button

  @Oppenheimer_US5 @Oppenheimer_US5_AC2
  Scenario: Verify text of dispense tax relief button
    Given I launch Oppenheimer application
    Then I should navigate to Landing page
    Then I should see "Dispense Now" button

  @Oppenheimer_US5 @Oppenheimer_US5_AC3
  Scenario: Verify text of dispense tax relief button
    Given I launch Oppenheimer application
    Then I should navigate to Landing page
    Then I should see "Dispense Now" button
    When I click on "Dispense Now" button
    Then I should navigate to Cash Dispensed page
