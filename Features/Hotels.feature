# new feature
# Tags: optional

Feature: Hotels.com web site testing
# 1
  @starCheck
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select property class <stars>
    Then I verify system displays only <stars> hotels on search result
    Examples:
      | stars   |
      | 5 stars |
      | 3 stars |
      | 2 stars |
# check with the 3 stars & 2 stars

#2
  @distance
  Scenario: List of all of hotel within 10 miles radius of airport or downtown // zip code 08837
    Given I am on default locations search result screen
    Then I verify system displays all hotels within "20" km radius of airport
    And I verify "JW Marriott Hotel" is within radius
#3
  @TodaysDealPrice
  Scenario: Verify todays deal price value
    Given I am on default locations search result screen
    Then I verify todays deal is less than "6000" rs
#4
  @roomcount
  Scenario Outline: Verify room count dropdown
    Given I am on hotels.com home page
    Then I select <select_rooms> from room dropdown
    And I verify <number_of_room_dropdown> is displayed
    Examples:
    |select_rooms | number_of_room_dropdown |
    |1            | 1                       |
    |2            | 2                       |
