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
  Scenario: Verify As the Clerk, I should be able to insert a single record of working class hero into database via an API
    Given I launch application via API
    When I insert a "multiple" record of working class hero into database via an API
    Then I should get success response
    When I search new record
    Then I should be able to read record

  @Oppenheimer_US3 @Oppenheimer_US3_AC1
  Scenario: Verify As the Clerk, I should be able to insert a single record of working class hero into database via an API
    Given I launch application via API
