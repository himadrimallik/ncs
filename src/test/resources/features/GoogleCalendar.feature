@googleCalendar
Feature: Verify Google Calendar application

  @E2E @MeetingSetup_Yes
  Scenario Outline: Verify User able to setup Meeting with Yes response in Google Calendar
    Given I launch Google Calendar application in "<Browser>"
    Then I should navigate to Landing page
    When I setup calendar meeting at "<Time>" on "<Date>" for "<Duration>" duration with "<Attendee>" list
    Then I should be able to see the invite in my calendar
    And meeting invite notification should be sent to "<Attendee>"
    When the "Attendee" provides "Yes" response on the invite email
    Then I should receive email with "Yes" response
    And my calendar should be updated with meeting alongwith "Yes" response

  Examples:
    |Browser|Time|Date|Duration|Attendee|
    |Chrome|12:00 PM|15-May-2021|30 mins|someone1@company.com|
    |Firefox|1:00 PM|15-May-2021|60 mins|someone1@company.com|
    |Edge|12:00 PM|15-May-2021|45 mins|someone1@company.com|
    |IE|10:00 AM|25-May-2021|30 mins|someone2@company.com|
    |Safari|10:30 PM|24-May-2021|30 mins|someone3@company.com|
    |iOS|4:00 PM|24-May-2021|30 mins|someone3@company.com|
    |ANdroid|5:00 PM|24-May-2021|30 mins|someone3@company.com|

  @E2E @MeetingSetup_MayBe
  Scenario Outline: Verify User able to setup Meeting with May Be response in Google Calendar
    Given I launch Google Calendar application in "<Browser>"
    Then I should navigate to Landing page
    When I setup calendar meeting at "<Time>" on "<Date>" for "<Duration>" duration with "<Attendee>" list
    Then I should be able to see the invite in my calendar
    And meeting invite notification should be sent to "<Attendee>"
    When the "Attendee" provides "May Be" response on the invite email
    Then I should receive email with "May Be" response
    And my calendar should be updated with meeting alongwith "May Be" response

    Examples:
      |Browser|Time|Date|Duration|Attendee|
      |Chrome|12:00 PM|15-May-2021|30 mins|someone1@company.com|
      |Firefox|1:00 PM|15-May-2021|60 mins|someone1@company.com|
      |Edge|12:00 PM|15-May-2021|45 mins|someone1@company.com|
      |IE|10:00 AM|25-May-2021|30 mins|someone2@company.com|
      |Safari|10:30 PM|24-May-2021|30 mins|someone3@company.com|
      |iOS|4:00 PM|24-May-2021|30 mins|someone3@company.com|
      |ANdroid|5:00 PM|24-May-2021|30 mins|someone3@company.com|

  @E2E @MeetingSetup_No
  Scenario Outline: Verify User able to setup Meeting with No response in Google Calendar
    Given I launch Google Calendar application in "<Browser>"
    Then I should navigate to Landing page
    When I setup calendar meeting at "<Time>" on "<Date>" for "<Duration>" duration with "<Attendee>" list
    Then I should be able to see the invite in my calendar
    And meeting invite notification should be sent to "<Attendee>"
    When the "Attendee" provides "No" response on the invite email
    Then I should receive email with "No" response
    And my calendar should not be updated with meeting

    Examples:
      |Browser|Time|Date|Duration|Attendee|
      |Chrome|12:00 PM|15-May-2021|30 mins|someone1@company.com|
      |Firefox|1:00 PM|15-May-2021|60 mins|someone1@company.com|
      |Edge|12:00 PM|15-May-2021|45 mins|someone1@company.com|
      |IE|10:00 AM|25-May-2021|30 mins|someone2@company.com|
      |Safari|10:30 PM|24-May-2021|30 mins|someone3@company.com|
      |iOS|4:00 PM|24-May-2021|30 mins|someone3@company.com|
      |ANdroid|5:00 PM|24-May-2021|30 mins|someone3@company.com|

  @E2E @RescheduleMeeting
  Scenario Outline: Verify User able to reschedule Meeting in Google Calendar
    Given I launch Google Calendar application in "<Browser>"
    Then I should navigate to Landing page
    When I search calendar for meeting at "<Time>" on "<Date>" for "<Duration>" duration with "<Attendee>" list
    Then I should be able to see the invite in my calendar
    When I reschedule the meeting at "<NewTime>" on "<NewDate>" for "<NewDuration>"
    Then meeting invite reschedule notification should be sent to "<Attendee>"
    When the "Attendee" provides "Yes" response on the invite email
    Then I should receive email with "Yes" response
    And my calendar should be updated with meeting alongwith "Yes" response

    Examples:
      |Browser|Time|Date|Duration|Attendee|NewTime|NewDate|NewDuration|
      |Chrome|12:00 PM|15-May-2021|30 mins|someone1@company.com|12.20 PM|15-May-2021|60 mins|
      |Firefox|1:00 PM|15-May-2021|60 mins|someone1@company.com|1.30 PM|15-May-2021|30 mins|
      |Edge|12:00 PM|15-May-2021|45 mins|someone1@company.com|12.00 PM|16-May-2021|45 mins|
      |IE|10:00 AM|25-May-2021|30 mins|someone2@company.com|110:00 AM|31-May-2021|30 mins|
      |Safari|10:30 PM|24-May-2021|30 mins|someone3@company.com|10:00 AM|25-May-2021|30 mins|
      |iOS|4:00 PM|24-May-2021|30 mins|someone3@company.com|12.20 PM|25-May-2021|30 mins|
      |ANdroid|5:00 PM|24-May-2021|30 mins|someone3@company.com|5.00 PM|24-May-2021|45 mins|


  @E2E @CancelMeeting
  Scenario Outline: Verify User able to cancel Meeting in Google Calendar
    Given I launch Google Calendar application in "<Browser>"
    Then I should navigate to Landing page
    When I search calendar for meeting at "<Time>" on "<Date>" for "<Duration>" duration with "<Attendee>" list
    Then I should be able to see the invite in my calendar
    When I cancel the meeting
    Then meeting invite cancel notification should be sent to "<Attendee>"
    And my calendar should be updated with removal of the meeting

    Examples:
      |Browser|Time|Date|Duration|Attendee|
      |Chrome|12:00 PM|15-May-2021|30 mins|someone1@company.com|
      |Firefox|1:00 PM|15-May-2021|60 mins|someone1@company.com|
      |Edge|12:00 PM|15-May-2021|45 mins|someone1@company.com|
      |IE|10:00 AM|25-May-2021|30 mins|someone2@company.com|
      |Safari|10:30 PM|24-May-2021|30 mins|someone3@company.com|
      |iOS|4:00 PM|24-May-2021|30 mins|someone3@company.com|
      |ANdroid|5:00 PM|24-May-2021|30 mins|someone3@company.com|

  @CornerCase @LowerBoundaryMeetingSetup
  Scenario: Verify User is able to set up Meeting with immediately before existing meeting in Google Calendar
    Given I launch Google Calendar application in "<Browser>"
    Then I should navigate to Landing page
    When I search calendar for existing meeting
    Then I should be able to see the invite in my calendar
    When I schedule the meeting with timing ending exactly before start time of existing meeting
    Then I should be able to see the invite in my calendar

  @CornerCase @UpperBoundaryMeetingSetup
  Scenario: Verify User is able to set up Meeting with immediately after existing meeting in Google Calendar
    Given I launch Google Calendar application in "<Browser>"
    Then I should navigate to Landing page
    When I search calendar for existing meeting
    Then I should be able to see the invite in my calendar
    When I schedule the meeting with timing starting exactly after end time of existing meeting
    Then I should be able to see the invite in my calendar

  @CornerCase @OverlapMeeting
  Scenario: Verify User is shown notification while setting up Meeting with overlapping time in Google Calendar
    Given I launch Google Calendar application in "<Browser>"
    Then I should navigate to Landing page
    When I search calendar for existing meeting
    Then I should be able to see the invite in my calendar
    When I schedule the meeting with overlapping timing
    Then I should be shown notification for overlapping timing