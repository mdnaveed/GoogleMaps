Feature: Location search on Google maps
  Google maps provide the user the facility to search for a location, this once submitted returns the location details in
  the response.
  The location search once submitted results in location results.

  Story
  As a Google maps user
  The user search for a location on the Google maps <Search Keyword provided by the User> so that
  the User can view the <results> for the searched <location>

  Scenario Outline:
    Given User is on the Google maps main page
    When User search for a location as "<searchKey>"
    Then User should see the results for the location searched as"<result>"
    And User close the Browser

    Examples:
      |searchKey|result         |
      |UK       |United Kingdom |
      |USA      |United States  |
      |India    |India          |