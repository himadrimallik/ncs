@Oppenheimer_API
Feature: Verify Oppenheimer project via API

  @Oppenheimer_US1 @Oppenheimer_US1_AC1
  Scenario: Verify As the Clerk, I should be able to insert a single record of working class hero into database via an API
    Given I launch application via API
    When I insert a "single" record of working class hero into database via an API
    Then I should get success response
    When I search new record
    Then I should be able to read record

  @Oppenheimer_US2 @Oppenheimer_US2_AC1
  Scenario: Verify As the Clerk, I should be able to insert more than one working class hero into database via an API
    Given I launch application via API
    When I insert a "multiple" record of working class hero into database via an API
    Then I should get success response
    When I search new record
    Then I should be able to read record

  @Oppenheimer_US3 @Oppenheimer_US3_AC1
  Scenario: Verify GET endpoint which returns a list consist of natid, tax relief, amount and name
    Given I launch application via API
    When I perform "Tax Relief" with API
    Then I should see a list consist of natid, tax relief, amount and name is returned

  @Oppenheimer_US3 @Oppenheimer_US3_AC2
  Scenario: Verify natid is masked in GET response
    Given I launch application via API
    When I perform "Tax Relief" with API
    Then I should see natid is masked

  @Oppenheimer_US3 @Oppenheimer_US3_AC3
  Scenario: Verify tax relief calculation
    Given I launch application via API
    When I perform "Tax Relief" with API
    Then I should see tax relief is calulated properly

  @Oppenheimer_US3 @Oppenheimer_US3_AC4
  Scenario: Verify tax relief rounding
    Given I launch application via API
    When I perform "Tax Relief" with API
    Then I should see tax relief is rounded

  @Oppenheimer_US3 @Oppenheimer_US3_AC5
  Scenario: Verify tax relief is 50
    Given I launch application via API
    When I perform "Tax Relief" with API
    Then I should see tax relief is 50

  @Oppenheimer_US3 @Oppenheimer_US3_AC6
  Scenario: Verify tax relief decimal truncating to 2 places
    Given I launch application via API
    When I perform "Tax Relief" with API
    Then I should see tax relief decimal places are truncated to 2 places
