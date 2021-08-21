@SPGroup
Feature: Verify SP Group Application

  @SPGroup_ReposPerWeek
  Scenario: Verify Repos per Week
    Given I launch "SP Group" application
    Then I should navigate to Landing page
    When I click on "repos per week" from Landing Page
    Then I should navigate to "repos per week" page
    Then I close Application

  @SPGroup_EventsPerWeek
  Scenario: Verify Events per Week
    Given I launch "SP Group" application
    Then I should navigate to Landing page
    When I click on "events per week" from Landing Page
    Then I should navigate to "events per week" page
    Then I close Application

  @SPGroup_MultipleLinks
  Scenario Outline: Verify <LinkType>
    Given I launch "SP Group" application
    Then I should navigate to Landing page
    When I click on "<LinkType>" from Landing Page
    Then I should navigate to "<PageName>" page
    Then I close Application

    Examples:
    |LinkType|PageName|
    |repos per week|repos per week|
    |events per week|events per week|

