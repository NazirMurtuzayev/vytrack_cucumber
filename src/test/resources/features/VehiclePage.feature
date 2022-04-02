@smoke
Feature: Vehicle Page

  User Story 91: As a user I should be able to see the car edited options on the Vehicle page


  Scenario Outline: User View Edit Car Info icons from the Vehicle page successfully
    Given users is on login page
    And There is a user "<username>" and "<password>"
    And user is on the homepage
    And user clicks the Vehicles under the Fleet
    Then Verify any car info has "3" dots “...”, and there are “view, edit, delete” icons.

    Examples:
      | username        | password    |
      | user1           | UserUser123 |
      | salesmanager120 | UserUser123 |
      | storemanager85  | UserUser123 |


















