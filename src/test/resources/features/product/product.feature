@tag
Feature: Product Page

  @tag1
  Scenario: Verify Product About Me Section
    Given User is on Amazon home page
    And User clicks on the hamburger menu
    And User shops by department
    And User selects televisions option
    When User filters brands by Samsung
    And User filters results from High to Low prices
    And User selects second highest priced item
    Then User should be shown the corresponding product page
    And About this item section should be present

 